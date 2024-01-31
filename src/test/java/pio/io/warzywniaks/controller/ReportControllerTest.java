package pio.io.warzywniaks.controller;

import lombok.NoArgsConstructor;
import org.instancio.Instancio;
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
import pio.io.warzywniaks.model.entity.User;
import pio.io.warzywniaks.model.repository.AdvertisementRepository;
import pio.io.warzywniaks.model.repository.ProductRepository;
import pio.io.warzywniaks.model.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        WarzywniaksApplication.class,
        H2Configuration.class})
@ActiveProfiles("test")
@NoArgsConstructor
public class ReportControllerTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReportController reportController;

    @Test
    public void shouldGenerateUsersReport() {
        //given
        User user1 = Instancio.create(User.class);
        User user2 = Instancio.create(User.class);
        User user3 = Instancio.create(User.class);
        Model model = new BindingAwareModelMap();
        userRepository.saveAll(List.of(user1, user2, user3));

        // when
        reportController.generateReport(2L, model);

        // then
        String payload = (String) model.getAttribute("payload");
        assertThat(payload).contains("Użytkownicy (3)");
        assertThat(payload).contains(user1.getFirstName(), user2.getFirstName(), user3.getFirstName());
    }
}