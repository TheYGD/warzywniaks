package pio.io.warzywniaks.service;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pio.io.warzywniaks.mapper.AdvertisementMapper;
import pio.io.warzywniaks.model.dto.CreateAdvertisementDTO;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementDTO;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementListDTO;
import pio.io.warzywniaks.model.entity.Advertisement;
import pio.io.warzywniaks.model.repository.AdvertisementRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertisementService {
    private final static AdvertisementMapper ADVERTISEMENT_MAPPER = AdvertisementMapper.INSTANCE;
    private final AdvertisementRepository advertisementRepository;


    public AdvertisementDTO getAdvertisement(Long id) {
        Advertisement advertisement = findAdvertisementById(id);
        return ADVERTISEMENT_MAPPER.toAdvertisementDTO(advertisement);
    }

    public List<AdvertisementDTO> getAdvertisements() {
        return advertisementRepository.findAll().stream()
                .map(ADVERTISEMENT_MAPPER::toAdvertisementDTO)
                .collect(Collectors.toList());
    }

    public AdvertisementDTO createAdvertisement(CreateAdvertisementDTO createAdvertisementDTO) {
        String imageBytes = getAdvertisementImageBytes(createAdvertisementDTO);
        Advertisement advertisement = ADVERTISEMENT_MAPPER.toAdvertisement(createAdvertisementDTO, imageBytes);
        advertisementRepository.save(advertisement);
        return ADVERTISEMENT_MAPPER.toAdvertisementDTO(advertisement);
    }

    public AdvertisementDTO updateAdvertisement(Long id, CreateAdvertisementDTO createAdvertisementDTO) {
        String imageBytes = getAdvertisementImageBytes(createAdvertisementDTO);
        Advertisement advertisement = findAdvertisementById(id);
        if (imageBytes.isBlank()) imageBytes = advertisement.getImage();

        ADVERTISEMENT_MAPPER.update(advertisement, createAdvertisementDTO, imageBytes);
        advertisementRepository.save(advertisement);
        return ADVERTISEMENT_MAPPER.toAdvertisementDTO(advertisement);
    }

    private String getAdvertisementImageBytes(CreateAdvertisementDTO createAdvertisementDTO) {
        try {
            return Base64.getEncoder().encodeToString(((MultipartFile) createAdvertisementDTO.image()).getBytes());

        } catch (IOException e) {
            return null;
        }
    }

    public void deleteAdvertisement(Long id) {
        Advertisement advertisement = findAdvertisementById(id);
        advertisementRepository.delete(advertisement);
    }

    private Advertisement findAdvertisementById(Long id) {
        return advertisementRepository.findById(id)
                .orElseThrow();
    }
}
