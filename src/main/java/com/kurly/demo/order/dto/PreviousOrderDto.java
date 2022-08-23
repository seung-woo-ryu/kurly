package com.kurly.demo.order.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PreviousOrderDto {
    private String deliveryImageUrl;
    private String requestInformation;

    private PreviousOrderDto(String deliveryImageUrl, String requestInformation) {
        this.deliveryImageUrl = deliveryImageUrl;
        this.requestInformation = requestInformation;
    }

    public static PreviousOrderDto of(String deliveryImageUrl, String requestInformation) {
        return new PreviousOrderDto(deliveryImageUrl, requestInformation);
    }
}
