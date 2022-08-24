package com.kurly.demo.check.controller;

import com.kurly.demo.check.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/check")
public class CheckController {
    private final CheckService checkService;
    @PostMapping("/room-number")
    public Boolean requestApi() {

        return true;
    }

    @GetMapping("/current-position")
    public Boolean get(@RequestParam("gps-address") String gpsAddress,@RequestParam("order-id") Long orderId) {
        return checkService.requestApi(gpsAddress, orderId);
    }
}
