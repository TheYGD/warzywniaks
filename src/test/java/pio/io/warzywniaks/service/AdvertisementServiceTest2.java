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

import static org.assertj.core.api.Assertions.assertThat;

class AdvertisementServiceTest2 {
    @Test
    void createAdvertisements() {
        // given
        CreateAdvertisementDTO createAdvertisementDTO1 = Instancio.create(CreateAdvertisementDTO.class);
        CreateAdvertisementDTO createAdvertisementDTO2 = Instancio.create(CreateAdvertisementDTO.class);

    }
}