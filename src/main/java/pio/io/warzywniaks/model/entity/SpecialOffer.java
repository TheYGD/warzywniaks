package pio.io.warzywniaks.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "special_offers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecialOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String info;
    private BigDecimal percentage;
    private LocalDate endDate;
    private LocalDate startDate;

    @ManyToMany
    @JoinTable(
            name = "available_produts_special_offers",
            joinColumns = @JoinColumn(name = "special_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "available_product_id"))
    List<AvailableProduct> availableProducts;

}
