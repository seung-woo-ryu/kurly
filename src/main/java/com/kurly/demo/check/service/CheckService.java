package com.kurly.demo.check.service;

import com.kurly.demo.check.dto.DocumentDto;
import com.kurly.demo.order.domain.Order;
import com.kurly.demo.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckService {
    private static final double THRESHOLD = 100;
    private final OrderService orderService;
    private final KakaoApiService kakaoApiService;
    public Boolean requestApi(String address, Long orderId) {
        Order order = orderService.getOrderByOrderId(orderId);

        DocumentDto currentAddress = getCoordinate(address);
        DocumentDto orderAddress = getCoordinate(order.getAddress());

        return isPassed(getDistance(currentAddress.getX(), currentAddress.getY(), orderAddress.getX(), orderAddress.getY()));
    }

    private boolean isPassed(double dist) {
        return dist < THRESHOLD;
    }

    private DocumentDto getCoordinate(String address) {
        return kakaoApiService.requestApi(address).getBody().getDocuments().get(0);
    }
    private double getDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1609.344;

        return dist;
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}