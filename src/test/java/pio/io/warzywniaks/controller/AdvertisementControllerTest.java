package pio.io.warzywniaks.controller;

import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import pio.io.warzywniaks.WarzywniaksApplication;
import pio.io.warzywniaks.config.H2Configuration;
import pio.io.warzywniaks.model.dto.advertisement.AdvertisementDTO;
import pio.io.warzywniaks.model.entity.Advertisement;
import pio.io.warzywniaks.model.repository.AdvertisementRepository;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        WarzywniaksApplication.class,
        H2Configuration.class})
@ActiveProfiles("test")
@NoArgsConstructor
public class AdvertisementControllerTest {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private AdvertisementController advertisementController;

    @Test
    public void shouldReturnSortedAdvertisementList() {
        //given
        Advertisement ad1 = new Advertisement(null, "nameA", "desc", "img", LocalDate.now(), LocalDate.now());
        Advertisement ad2 = new Advertisement(null, "nameB", "desc", "img", LocalDate.now(), LocalDate.now());
        Advertisement ad3 = new Advertisement(null, "nameC", "desc", "img", LocalDate.now(), LocalDate.now());
        Model model = new BindingAwareModelMap();
        advertisementRepository.saveAll(List.of(ad3, ad2, ad1));

        // when
        advertisementController.getAdvertisements(model);

        // then
        List<AdvertisementDTO> advertisements = (List<AdvertisementDTO>) model.getAttribute("advertisements");
        assertThat(advertisements).hasSize(3);
        assertThat(advertisements).map(AdvertisementDTO::name).containsExactly("nameA", "nameB", "nameC");
    }

    @Test
    public void shouldDeleteAdvertisement() {
        //given
        Advertisement ad1 = new Advertisement(null, "nameA", "desc", "img", LocalDate.now(), LocalDate.now());
        Advertisement ad2 = new Advertisement(null, "nameB", "desc", "img", LocalDate.now(), LocalDate.now());
        advertisementRepository.saveAll(List.of(ad2, ad1));

        // when
        advertisementController.deleteAdvertisement(ad1.getId());

        // then
        List<Advertisement> advertisements = advertisementRepository.findAll();
        assertThat(advertisements).hasSize(1);
        assertThat(advertisements).map(Advertisement::getName).containsExactly("nameB");
    }
}