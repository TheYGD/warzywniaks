package pio.io.warzywniaks.model.dto.order;

import pio.io.warzywniaks.model.dto.orderedProduct.OrderedProductDTO;
import pio.io.warzywniaks.model.entity.DeliveryDetails;
import pio.io.warzywniaks.model.entity.PaymentDetails;

import java.util.List;

public record OrderDTO(long id, DeliveryDetails deliveryDetails, PaymentDetails paymentDetails, String deliveryAddress, List<OrderedProductDTO> orderedProducts, String userLogin) {
}
