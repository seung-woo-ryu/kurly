package com.kurly.demo.order.controller;

import com.kurly.demo.order.dto.OrderHistoryResponseDto;
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
    public ResponseEntity<OrderHistoryResponseDto> get(@PathVariable("order_id") Long orderId) {
        OrderHistoryResponseDto previousOrders = orderService.getPreviousOrdersBy(orderId);
        return new ResponseEntity<>(previousOrders, HttpStatus.OK);
    }
    @GetMapping("/user/{user_id}")
    public ResponseEntity<OrderHistoryResponseDto> getAll(@PathVariable("user_id") Long deliveryManId) {
        OrderHistoryResponseDto nowOrders = orderService.getNowOrdersBy(deliveryManId);
        return new ResponseEntity<>(nowOrders, HttpStatus.OK);
    }
}
