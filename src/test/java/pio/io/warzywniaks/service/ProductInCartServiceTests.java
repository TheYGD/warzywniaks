package pio.io.warzywniaks.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import pio.io.warzywniaks.model.entity.*;
import pio.io.warzywniaks.model.repository.ProductInCartRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class ProductInCartServiceTests {

    @Mock
    ProductInCartRepository productInCartRepository;
    @InjectMocks
    ProductInCartService productInCartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addQuantity() {
        Product product = new Product(1L, "img", "test", "123", "10", BigDecimal.valueOf(10), new Category(1, "category"));
        AvailableProduct availableProduct = new AvailableProduct(1L, product, 2, " ");
        ProductInCart productInCart = new ProductInCart(1L, new Cart(), availableProduct, 1);

        when(productInCartRepository.getById(any())).thenReturn(productInCart);

        productInCartService.addProductToCart(productInCart);

        productInCartService.addQuantity(1L);

        verify(productInCartRepository).getById(1L);

        assertEquals(2, productInCartService.getProductInCart(1L).getQuantity());

    }
}