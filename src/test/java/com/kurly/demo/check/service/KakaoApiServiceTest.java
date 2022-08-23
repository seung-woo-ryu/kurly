package com.kurly.demo.check.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kurly.demo.check.dto.KakaoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class KakaoApiServiceTest {
    @Autowired
    private KakaoApiService kakaoApiService;

    @Test
    void requestApi() throws JsonProcessingException {
        String address = "성북구 보문사길 111";

        ResponseEntity<KakaoDto> responseEntity = kakaoApiService.requestApi(address);
        KakaoDto result = responseEntity.getBody();

        System.out.println(result);
        assertThat(result.getDocuments()).hasSize(1);
    }
}