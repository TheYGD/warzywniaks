package pio.io.warzywniaks.service;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pio.io.warzywniaks.WarzywniaksApplication;
import pio.io.warzywniaks.config.H2Configuration;
import pio.io.warzywniaks.model.dto.CreateAdvertisementDTO;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementDTO;
import pio.io.warzywniaks.model.entity.Advertisement;
import pio.io.warzywniaks.model.repository.AdvertisementRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        WarzywniaksApplication.class,
        H2Configuration.class})
@ActiveProfiles("test")
class AdvertisementServiceTest {
    @Autowired
    private AdvertisementService advertisementService;

    @Test
    void createAdvertisements() {
        // given
        CreateAdvertisementDTO createAdvertisementDTO1 = Instancio.create(CreateAdvertisementDTO.class);
        CreateAdvertisementDTO createAdvertisementDTO2 = Instancio.create(CreateAdvertisementDTO.class);

        // when
        AdvertisementDTO ad1 = advertisementService.createAdvertisement(createAdvertisementDTO1);
        AdvertisementDTO ad2 = advertisementService.createAdvertisement(createAdvertisementDTO2);

        // then
        assertThat(advertisementService.getAdvertisements()).hasSize(2);
        assertThatAdvertisementIsCreatedCorrectly(ad1, createAdvertisementDTO1);
        assertThatAdvertisementIsCreatedCorrectly(ad2, createAdvertisementDTO2);
    }

    @Test
    void updateAdvertisement() {

    }

    private void assertThatAdvertisementIsCreatedCorrectly(AdvertisementDTO ad, CreateAdvertisementDTO createAdvertisementDTO) {
        assertThat(ad)
                .returns(createAdvertisementDTO.name(), AdvertisementDTO::name)
                .returns(createAdvertisementDTO.description(), AdvertisementDTO::description)
                .returns(createAdvertisementDTO.imageUrl(), AdvertisementDTO::imageUrl);

        assertThat(ad.productIds()).hasSize(createAdvertisementDTO.productIds().size());
    }
}