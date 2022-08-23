package com.kurly.demo.order.controller;

import com.kurly.demo.order.dto.ResponseDto;
import com.kurly.demo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/{order_id}/previous-orders")
    public ResponseEntity<ResponseDto> get(@PathVariable("order_id") Long orderId) {
        ResponseDto previousOrders = orderService.getPreviousOrders(orderId);
        return new ResponseEntity<>(previousOrders, HttpStatus.OK);
    }
}
