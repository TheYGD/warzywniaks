package pio.io.warzywniaks.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.model.entity.ProductInCart;
import pio.io.warzywniaks.model.repository.ProductInCartRepository;

import java.util.List;

@Service
public class ProductInCartService {
    private final ProductInCartRepository productInCartRepository;

    public ProductInCartService(ProductInCartRepository productInCartRepository) {
        this.productInCartRepository = productInCartRepository;
    }

    @Transactional
    public void removeProduct(Long id){
        ProductInCart product = productInCartRepository.getById(id);
        int quantity = product.getQuantity();
        int amount = product.getAvailableProduct().getAmount();
        product.getAvailableProduct().setAmount(amount+quantity);
        productInCartRepository.deleteById(id);
    }

    public void addProductToCart(ProductInCart productInCart){
        productInCartRepository.save(productInCart);
    }

    public ProductInCart getProductInCart(Long productId){
        return productInCartRepository.getById(productId);
    }
    @Transactional
    public void subtractQuantity(Long productId) {
        ProductInCart product = productInCartRepository.getById(productId);
        product.setQuantity(product.getQuantity() - 1);
        int amount = product.getAvailableProduct().getAmount();
        product.getAvailableProduct().setAmount(amount+1);

        if (product.getQuantity() <= 0) {
            List<ProductInCart> list = product.getCart().getProducts();
            list.remove(product);
            product.getCart().setProducts(list);
            removeProduct(productId);
        }
    }

    @Transactional
    public void addQuantity(Long productId) {
        ProductInCart product = productInCartRepository.getById(productId);
        int amount = product.getAvailableProduct().getAmount();
        if (amount>0){
            product.setQuantity(product.getQuantity() + 1);
            product.getAvailableProduct().setAmount(amount-1);
        }
    }
}
