package pio.io.warzywniaks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.model.entity.Product;
import pio.io.warzywniaks.model.entity.ProductInCart;
import pio.io.warzywniaks.model.entity.SpecialOffer;
import pio.io.warzywniaks.model.repository.SpecialOfferRepository;
import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.List;


@Service
public class SpecialOfferService {
    private final SpecialOfferRepository specialOfferRepository;

    @Autowired
    public SpecialOfferService(SpecialOfferRepository specialOfferRepository) {
        this.specialOfferRepository = specialOfferRepository;
    }

    public List<SpecialOffer> getAllSpecialOffers() {
        return specialOfferRepository.findAll();
    }

    public BigDecimal calculateFinalPrice(AvailableProduct availableProduct) {
        BigDecimal finalPrice = availableProduct.getProduct().getPrice();

        for (SpecialOffer specialOffer : availableProduct.getSpecialOffers()) {
            if (isOfferValid(specialOffer)) {
                BigDecimal discountMultiplier = BigDecimal.ONE.subtract(specialOffer.getPercentage().divide(BigDecimal.valueOf(100)));
                finalPrice = finalPrice.multiply(discountMultiplier);
            }
        }

        return finalPrice;
    }

    public BigDecimal calculatePriceInCart(ProductInCart productInCart){
        Product product = productInCart.getAvailableProduct().getProduct();
        return product.getPrice().multiply(BigDecimal.valueOf(productInCart.getQuantity()));
    }
    public BigDecimal calculateDiscountInCart(ProductInCart productInCart){
        BigDecimal totalPrice = calculatePriceInCart(productInCart);
        BigDecimal finalPrice = calculateFinalPrice(productInCart.getAvailableProduct()).multiply(BigDecimal.valueOf(productInCart.getQuantity()));
        return  totalPrice.subtract(finalPrice);
    }


    public boolean isOfferValid(SpecialOffer specialOffer) {
        LocalDate currentDate = LocalDate.now();
        return !currentDate.isBefore(specialOffer.getStartDate()) && !currentDate.isAfter(specialOffer.getEndDate());
    }

    public BigDecimal calculateTotalPriceInCart(List<ProductInCart> products){
        BigDecimal total = BigDecimal.valueOf(0);
        for (ProductInCart product : products){
            total = total.add(calculatePriceInCart(product));
        }
        return total;
    }

    public BigDecimal calculateTotalDiscountInCart(List<ProductInCart> products){
        BigDecimal discounts = BigDecimal.valueOf(0);
        for (ProductInCart product : products){
            discounts = discounts.add(calculateDiscountInCart(product));
        }

        return discounts;
    }

    public BigDecimal calculateFinalPriceInCart(List<ProductInCart> products){
        return calculateTotalPriceInCart(products).subtract(calculateTotalDiscountInCart(products));
    }
    public SpecialOffer getSpecialOfferById(long id) {
        SpecialOffer offer = specialOfferRepository.findById(id).orElseThrow(RuntimeException::new);
        return offer;

    }

}
