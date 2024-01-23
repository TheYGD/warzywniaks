package pio.io.warzywniaks.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "available_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int amount;
    private String description;
    @ManyToMany(mappedBy = "availableProducts")
    private List<SpecialOffer> specialOffers;

    public AvailableProduct(long id, Product product, int amount, String description) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.description = description;
    }
}
