package pio.io.warzywniaks.model.dto.order;

import pio.io.warzywniaks.model.dto.orderedProduct.OrderedProductDTO;
import pio.io.warzywniaks.model.entity.DeliveryDetails;
import pio.io.warzywniaks.model.entity.PaymentDetails;

import java.math.BigDecimal;
import java.util.List;

public record OrderDTO(Long id, DeliveryDetails deliveryDetails, PaymentDetails paymentDetails, String deliveryAddress, List<OrderedProductDTO> orderedProducts, String userLogin, String status, BigDecimal total) {
}
