package pio.io.warzywniaks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.controller.request.order.ChangeOrderStatusRequest;
import pio.io.warzywniaks.model.dto.order.OrderDTO;
import pio.io.warzywniaks.model.dto.order.OrderListDTO;
import pio.io.warzywniaks.model.dto.orderedProduct.OrderedProductDTO;
import pio.io.warzywniaks.model.entity.DeliveryDetails;
import pio.io.warzywniaks.model.entity.Order;
import pio.io.warzywniaks.model.repository.OrderRepository;

import java.util.ArrayList;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderListDTO getAllOrders() {
        return new OrderListDTO(
                orderRepository.findAll().stream().map(
                        order -> new OrderDTO(order.getId(), order.getDelivery(), order.getPayment(),order.getAddress(),
                                new ArrayList<OrderedProductDTO>(), order.getUser().getLogin())).toList());
    }

    public OrderDTO getOrder(long id) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);

        return new OrderDTO(order.getId(), order.getDelivery(), order.getPayment(),
                order.getAddress(),new ArrayList<OrderedProductDTO>() , order.getUser().getLogin());
    }


    public void updateOrderStatus(long id, ChangeOrderStatusRequest request) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        order.setOrderStatus(request.newStatus());
        orderRepository.save(order);

    }
}

