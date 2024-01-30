package pio.io.warzywniaks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pio.io.warzywniaks.model.dto.CreateAdvertisementDTO;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementDTO;
import pio.io.warzywniaks.model.entity.Advertisement;

@Mapper
public interface AdvertisementMapper {
    AdvertisementMapper INSTANCE = Mappers.getMapper(AdvertisementMapper.class);

    Advertisement toAdvertisement(CreateAdvertisementDTO createAdvertisementDTO);
    AdvertisementDTO toAdvertisementDTO(Advertisement advertisement);

    void update(@MappingTarget Advertisement advertisement, CreateAdvertisementDTO createAdvertisementDTO);
}
