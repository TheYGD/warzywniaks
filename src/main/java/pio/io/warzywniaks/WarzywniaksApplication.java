package pio.io.warzywniaks;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.model.entity.SpecialOffer;
import pio.io.warzywniaks.model.repository.AvailableProductRepository;
import pio.io.warzywniaks.model.repository.SpecialOfferRepository;
import java.util.ArrayList;

import java.util.List;


@SpringBootApplication
public class WarzywniaksApplication{

    public static void main(String[] args) {
        SpringApplication.run(WarzywniaksApplication.class, args);
    }

}
