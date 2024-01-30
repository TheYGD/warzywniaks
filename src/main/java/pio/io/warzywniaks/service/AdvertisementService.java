package pio.io.warzywniaks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.mapper.AdvertisementMapper;
import pio.io.warzywniaks.model.dto.CreateAdvertisementDTO;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementDTO;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementListDTO;
import pio.io.warzywniaks.model.entity.Advertisement;
import pio.io.warzywniaks.model.repository.AdvertisementRepository;

import java.util.List;

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
                .toList();
    }

    public AdvertisementDTO createAdvertisement(CreateAdvertisementDTO createAdvertisementDTO) {
        Advertisement advertisement = ADVERTISEMENT_MAPPER.toAdvertisement(createAdvertisementDTO);
        advertisementRepository.save(advertisement);
        return ADVERTISEMENT_MAPPER.toAdvertisementDTO(advertisement);
    }

    public AdvertisementDTO updateAdvertisement(Long id, CreateAdvertisementDTO createAdvertisementDTO) {
        Advertisement advertisement = findAdvertisementById(id);
        ADVERTISEMENT_MAPPER.update(advertisement, createAdvertisementDTO);
        advertisementRepository.save(advertisement);
        return ADVERTISEMENT_MAPPER.toAdvertisementDTO(advertisement);
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
