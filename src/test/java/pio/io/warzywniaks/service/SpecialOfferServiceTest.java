package pio.io.warzywniaks.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pio.io.warzywniaks.model.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class SpecialOfferServiceTest {
    @InjectMocks
    private SpecialOfferService specialOfferService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculatePriceInCart() {
        Product product = new Product(1, "img", "test", "123", "10",
                BigDecimal.valueOf(10), new Category(1, "category"));
        AvailableProduct availableProduct = new AvailableProduct(1, product, 2, " ");
        ProductInCart productInCart = new ProductInCart(availableProduct, 3, new Cart());
        BigDecimal result = specialOfferService.calculatePriceInCart(productInCart);
        assertEquals(BigDecimal.valueOf(30), result);
    }

    @Test
    public void testIsOfferValid() {
        SpecialOffer specialOffer = new SpecialOffer(1L, "Offer", BigDecimal.valueOf(10),
                LocalDate.now().plusDays(1), LocalDate.now().minusDays(1));
        boolean result = specialOfferService.isOfferValid(specialOffer);
        assertTrue(result);
    }
}