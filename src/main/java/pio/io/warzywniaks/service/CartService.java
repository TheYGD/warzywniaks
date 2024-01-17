package pio.io.warzywniaks.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.model.entity.ProductInCart;
import pio.io.warzywniaks.model.entity.Cart;
import pio.io.warzywniaks.model.repository.CartRepository;
import pio.io.warzywniaks.model.repository.ProductInCartRepository;

import java.util.Optional;


@Service
public class CartService {
    final CartRepository cartRepository;
    final ProductInCartRepository productInCartRepository;

    public CartService(CartRepository cartRepository, ProductInCartRepository productInCartRepository) {
        this.cartRepository = cartRepository;
        this.productInCartRepository = productInCartRepository;
    }

    @Transactional
    public void addToCart(AvailableProduct product, int quantity) {
        Cart cart = getCart();

        Optional<ProductInCart> existingProductInCart = cart.getProducts().stream()
                .filter(p -> p.getAvailableProduct().equals(product))
                .findFirst();

        if (existingProductInCart.isPresent()) {
            existingProductInCart.get().setQuantity(existingProductInCart.get().getQuantity() + quantity);
        } else {
            ProductInCart productInCart = new ProductInCart(product, quantity, cart);
            cart.getProducts().add(productInCart);
            productInCartRepository.save(productInCart);
        }

        cartRepository.save(cart);
    }

    public Cart getCart() {
        return cartRepository.getById(1L);
    }
}
