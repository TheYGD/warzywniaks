package pio.io.warzywniaks.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pio.io.warzywniaks.model.constant.DeliveryStatus;

@Entity
@Table(name = "delivery_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String externalId;
    private DeliveryStatus status;
}
