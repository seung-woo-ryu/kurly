package com.kurly.demo.order.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OrderHistoryDto {
    private Long orderId;
    private String deliveryImageUrl;
    private String requestInformation;

    private OrderHistoryDto(Long orderId, String deliveryImageUrl, String requestInformation) {
        this.orderId = orderId;
        this.deliveryImageUrl = deliveryImageUrl;
        this.requestInformation = requestInformation;
    }

    public static OrderHistoryDto of(Long orderId, String deliveryImageUrl, String requestInformation) {
        return new OrderHistoryDto(orderId,deliveryImageUrl, requestInformation);
    }
}
