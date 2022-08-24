package com.kurly.demo.order.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;
    @Test
    void getOrderByOrderId() {
        Long WRONG_ID = 404L;

        Assertions.assertThrows(EntityNotFoundException.class,
                () -> orderService.getOrderByOrderId(WRONG_ID));
    }
}