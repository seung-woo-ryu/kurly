package com.kurly.demo.order.repository;

import com.kurly.demo.order.domain.Order;
import com.kurly.demo.user.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByUser_IdAndIsCompleted(Long userId,boolean isCompleted);
    List<Order> findAllByDeliveryUser_idAndDeliveryUser_Role(Long deliveryManId, Role role);
}
