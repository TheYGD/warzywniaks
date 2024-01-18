package pio.io.warzywniaks.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pio.io.warzywniaks.controller.request.order.ChangeOrderStatusRequest;
import pio.io.warzywniaks.model.dto.order.OrderDTO;
import pio.io.warzywniaks.model.dto.order.OrderListDTO;
import pio.io.warzywniaks.model.dto.orderedProduct.OrderedProductDTO;
import pio.io.warzywniaks.model.entity.AvailableProduct;
import pio.io.warzywniaks.model.entity.Order;
import pio.io.warzywniaks.model.entity.OrderedProduct;
import pio.io.warzywniaks.model.repository.OrderRepository;
import pio.io.warzywniaks.model.repository.OrderedProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderedProductRepository orderedProductRepository;

    public OrderListDTO getAllOrders() {
        return new OrderListDTO(
                orderRepository.findAll().stream().map(
                        order -> new OrderDTO(order.getId(), order.getDelivery(), order.getPayment(),order.getAddress(),
                                orderedProductRepository.getProductsByOrder(order.getId())
                                        .stream()
                                        .map(product -> new OrderedProductDTO(product.getId(), product.getProduct().getName(), product.getAmount()))
                                        .toList(),
                                order.getUser().getLogin()
                                ,order.getOrderStatus().toString(),
                                calculateTotal(orderedProductRepository.getProductsByOrder(order.getId()))

                        )
                ).toList());
    }
    private BigDecimal calculateTotal(List<OrderedProduct> productList){
        BigDecimal sum = new BigDecimal(0);
        for (OrderedProduct product : productList){
            BigDecimal temp = product.getProduct().getPrice().multiply(new BigDecimal(product.getAmount()));
            sum = sum.add(temp);
        }
        return sum;
    }

    public OrderDTO getOrder(long id) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);

        return new OrderDTO(order.getId(), order.getDelivery(), order.getPayment(),order.getAddress(),
                orderedProductRepository.getProductsByOrder(order.getId())
                        .stream()
                        .map(product -> new OrderedProductDTO(product.getId(), product.getProduct().getName(), product.getAmount()))
                        .toList(),
                order.getUser().getLogin()
                ,order.getOrderStatus().toString(),
                calculateTotal(orderedProductRepository.getProductsByOrder(order.getId())));
    }


    public void updateOrderStatus(long id, ChangeOrderStatusRequest request) {
        Order order = orderRepository.findById(id).orElseThrow(RuntimeException::new);
        order.setOrderStatus(request.newStatus());
        orderRepository.save(order);

    }
}

