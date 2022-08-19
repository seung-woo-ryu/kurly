package com.kurly.demo.check.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/check")
public class CheckController {

    @PostMapping("/room-number")
    public Boolean requestApi() {

        return true;
    }
}
