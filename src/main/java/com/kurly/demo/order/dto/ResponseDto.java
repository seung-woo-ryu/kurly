package com.kurly.demo.order.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResponseDto {
    private Long userId;
    private List<PreviousOrderDto> previousOrderDtoList;

    private ResponseDto(Long userId, List<PreviousOrderDto> previousOrderDtoList) {
        this.userId = userId;
        this.previousOrderDtoList = previousOrderDtoList;
    }

    public static ResponseDto of(Long userId, List<PreviousOrderDto> previousOrderDtoList) {
        return new ResponseDto(userId, previousOrderDtoList);
    }
}
