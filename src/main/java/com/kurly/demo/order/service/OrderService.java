package com.kurly.demo.order.service;

import com.kurly.demo.order.domain.Order;
import com.kurly.demo.order.dto.PreviousOrderDto;
import com.kurly.demo.order.dto.ResponseDto;
import com.kurly.demo.order.repository.OrderRepository;
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

    public ResponseDto getPreviousOrders(Long orderId) {
        Order myOrder = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
        // findall 시험해보기.
        List<Order> allByUser_id = orderRepository.findAllByUser_Id(myOrder.getUser().getId());
        List<PreviousOrderDto> previousOrderDtoList = allByUser_id
                .stream()
                .filter(o -> o.getId() != orderId)
                .map(order -> {
                    return PreviousOrderDto.of(order.getImageUrl(), order.getRequestInformation());})
                .collect(Collectors.toList());

        return ResponseDto.of(myOrder.getUser().getId(), previousOrderDtoList);
    }
}
