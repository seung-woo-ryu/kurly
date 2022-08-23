package com.kurly.demo.order.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kurly.demo.user.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderHistoryResponseDto {
    private Long userId;
    private String userType;
    private List<OrderHistoryDto> orderHistoryDtoList;

    private OrderHistoryResponseDto(Long userId, List<OrderHistoryDto> orderHistoryDtoList, Role role) {
        this.userId = userId;
        this.orderHistoryDtoList = orderHistoryDtoList;
        this.userType = role.getValue();
    }

    public static OrderHistoryResponseDto of(Long userId, List<OrderHistoryDto> orderHistoryDtoList,Role role) {
        return new OrderHistoryResponseDto(userId, orderHistoryDtoList,role);
    }
}
