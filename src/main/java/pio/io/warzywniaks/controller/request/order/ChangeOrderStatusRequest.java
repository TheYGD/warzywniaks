package pio.io.warzywniaks.controller.request.order;

import pio.io.warzywniaks.model.constant.DeliveryStatus;
import pio.io.warzywniaks.model.constant.OrderStatus;

public record ChangeOrderStatusRequest(OrderStatus newStatus) {
}
