package com.kurly.demo.order.repository;

import com.kurly.demo.order.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static com.kurly.demo.common.datainitializer.DataInitializer.testOrder1;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    
    @Test
    public void findById() {
        Long id = testOrder1.getId();

        Order findOrder = orderRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        assertThat(findOrder.getAddress()).isEqualTo(testOrder1.getAddress());
        assertThat(findOrder.getImageUrl()).isEqualTo(testOrder1.getImageUrl());
        assertThat(findOrder.getUser().getId()).isEqualTo(testOrder1.getUser().getId());
    }

    @Test
    void findAllByUser_IdAndIsCompleted() {
        Long id = testOrder1.getUser().getId();

        List<Order> result = orderRepository.findAllByUser_IdAndIsCompleted(id, true);

        assertThat(result).hasSize(2);
    }
}