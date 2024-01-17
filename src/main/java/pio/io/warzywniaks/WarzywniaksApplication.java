package pio.io.warzywniaks;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.model.entity.SpecialOffer;
import pio.io.warzywniaks.model.repository.AvailableProductRepository;
import pio.io.warzywniaks.model.repository.SpecialOfferRepository;
import pio.io.warzywniaks.service.AvailableProductService;
import pio.io.warzywniaks.service.SpecialOfferService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class WarzywniaksApplication{

//    @Autowired
//    SpecialOfferRepository specialOfferRepository;
//    @Autowired
//    AvailableProductRepository availableProductRepository;

    public static void main(String[] args) {
        SpringApplication.run(WarzywniaksApplication.class, args);
    }

//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
//        AvailableProduct availableProduct = availableProductRepository.getById(1L);
//        AvailableProduct availableProduct2 = availableProductRepository.getById(3L);
//        List<AvailableProduct> availableProducts = new ArrayList<AvailableProduct>();
//        availableProducts.add(availableProduct);
//        availableProducts.add(availableProduct2);
//
//        SpecialOffer news = new SpecialOffer(2L, new BigDecimal(15), LocalDate.of(2024,2,1), LocalDate.of(2023,12,29), availableProducts);
//        specialOfferRepository.save(news);
//
//    }
}
