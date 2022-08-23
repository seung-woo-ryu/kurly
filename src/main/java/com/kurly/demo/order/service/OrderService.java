package com.kurly.demo.order.service;

import com.kurly.demo.order.domain.Order;
import com.kurly.demo.order.dto.OrderHistoryDto;
import com.kurly.demo.order.dto.OrderHistoryResponseDto;
import com.kurly.demo.order.repository.OrderRepository;
import com.kurly.demo.user.domain.Role;
import com.kurly.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    public Order getOrderByOrderId(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public OrderHistoryResponseDto getPreviousOrdersBy(Long orderId) {
        Order myOrder = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);

        List<Order> allByUser_id = orderRepository.findAllByUser_IdAndIsCompleted(myOrder.getUser().getId(),true);
        List<OrderHistoryDto> orderHistoryDtoList = allByUser_id
                .stream()
                .filter(o -> o.getId() != orderId)
                .map(order -> {
                    return OrderHistoryDto.of(order.getId(),order.getImageUrl(), order.getRequestInformation());})
                .collect(Collectors.toList());

        return OrderHistoryResponseDto.of(myOrder.getUser().getId(), orderHistoryDtoList,Role.ROLE_USER);
    }

    public OrderHistoryResponseDto getNowOrdersBy(Long deliveryManId) {
        List<Order> result = orderRepository.findAllByDeliveryUser_idAndDeliveryUser_Role(deliveryManId, Role.ROLE_DELIVERY_MAN);

        List<OrderHistoryDto> nowOrderDtoList = result
                .stream()
                .map(order -> {
                    return OrderHistoryDto.of(order.getId(),order.getImageUrl(), order.getRequestInformation());})
                .collect(Collectors.toList());

        return OrderHistoryResponseDto.of(deliveryManId, nowOrderDtoList,Role.ROLE_DELIVERY_MAN);
    }
}
