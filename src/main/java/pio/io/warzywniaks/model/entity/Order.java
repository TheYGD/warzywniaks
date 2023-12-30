package pio.io.warzywniaks.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private PaymentDetails payment;
    @OneToOne
    @JoinColumn(name = "delivery_id")
    private DeliveryDetails delivery;
    private String address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
