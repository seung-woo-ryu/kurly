package com.kurly.demo.order.controller;

import com.kurly.demo.order.dto.ResponseDto;
import com.kurly.demo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/api/previous-orders")
    public String get(@PathVariable("order_id")Long orderId) {
        ResponseDto previousOrders = orderService.getPreviousOrders(orderId);
        return "true";
    }
}
