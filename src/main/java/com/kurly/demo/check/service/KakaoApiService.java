package com.kurly.demo.check.service;

import com.kurly.demo.check.dto.KakaoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KakaoApiService {
    private static final String SEARCH_ADDRESS_URL = "https://dapi.kakao.com/v2/local/search/address.json";

    @Value("${kakao.key}")
    private String kakaoKey;

    public ResponseEntity<KakaoDto> requestApi(String address) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + kakaoKey);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return restTemplate.exchange(SEARCH_ADDRESS_URL+"?query="+ address,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                KakaoDto.class);
    }
}