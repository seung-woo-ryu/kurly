package com.kurly.demo.order.repository;

import com.kurly.demo.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByUser_Id(Long userId);
}
