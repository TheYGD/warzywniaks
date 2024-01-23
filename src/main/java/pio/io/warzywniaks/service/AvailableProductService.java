package pio.io.warzywniaks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.model.repository.AvailableProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvailableProductService {
    private final AvailableProductRepository availableProductRepository;

    @Autowired
    public AvailableProductService(AvailableProductRepository availableProductRepository) {
        this.availableProductRepository = availableProductRepository;
    }

    public List<AvailableProduct> getAllAvailableProducts(){
        return availableProductRepository.findAll();
    }

    public AvailableProduct getProductById(Long id){
        return availableProductRepository.getById(id);
    }

    public List<AvailableProduct> getAvailableProductsByCategory(Long id){
        List<AvailableProduct> productsWithCategory = new ArrayList<>();
        for( AvailableProduct availableProduct : getAllAvailableProducts()){
            if(availableProduct.getProduct().getCategory().getId() == id){
                productsWithCategory.add(availableProduct);
            }
        }
        return productsWithCategory;
    }

    public void subtractAmount(Long id, int n){
        AvailableProduct product = availableProductRepository.getById(id);
        int amount = product.getAmount();
        if(amount - n>=0){
            product.setAmount(amount - n);
            availableProductRepository.save(product);
        }
    }

    public void addAmount(Long id, int n){
        AvailableProduct product = availableProductRepository.getById(id);
        int amount = product.getAmount();
        product.setAmount(amount + n);
        availableProductRepository.save(product);
    }




}
