package com.kurly.demo.check.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class KakaoDto {
    List<DocumentDto> documents;
}
