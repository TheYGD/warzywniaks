package pio.io.warzywniaks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pio.io.warzywniaks.controller.request.order.ChangeOrderStatusRequest;
import pio.io.warzywniaks.model.dto.order.OrderDTO;
import pio.io.warzywniaks.model.dto.order.OrderListDTO;
import pio.io.warzywniaks.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/all")
    public ResponseEntity<OrderListDTO> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<OrderDTO> getOrderDetails(@PathVariable long id){
        return new ResponseEntity<>(orderService.getOrder(id),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/{id}/update/status")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void updateOrderStatus(@PathVariable long id, @RequestBody ChangeOrderStatusRequest request){
        orderService.updateOrderStatus(id,request);
    }

}
