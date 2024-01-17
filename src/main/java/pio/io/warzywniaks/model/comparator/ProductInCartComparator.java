package pio.io.warzywniaks.model.comparator;

import pio.io.warzywniaks.model.entity.ProductInCart;

import java.util.Comparator;

public class ProductInCartComparator implements Comparator<ProductInCart> {

    @Override
    public int compare(ProductInCart p1, ProductInCart p2) {
        return Long.compare(p1.getId(), p2.getId());
    }
}