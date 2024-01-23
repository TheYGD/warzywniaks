package pio.io.warzywniaks.model.comparator;

import pio.io.warzywniaks.model.entity.AvailableProduct;


import java.util.Comparator;

public class AvailableProductComparator implements Comparator<AvailableProduct> {

    @Override
    public int compare(AvailableProduct p1, AvailableProduct p2) {
        return Long.compare(p1.getId(), p2.getId());
    }
}