package pio.io.warzywniaks.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products_in_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "availableProduct_id")
    private AvailableProduct availableProduct;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public ProductInCart(AvailableProduct product, int quantity, Cart cart) {
        this.availableProduct = product;
        this.quantity = quantity;
        this.cart = cart;
    }
}