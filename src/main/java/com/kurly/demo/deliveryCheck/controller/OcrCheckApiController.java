package com.kurly.demo.deliveryCheck.controller;

import com.kurly.demo.deliveryCheck.service.OcrCheckService;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

@RestController
@RequiredArgsConstructor
public class OcrCheckApiController {
    private final OcrCheckService ocrCheckService;

    @PostMapping("/api/check/room-number")
    public boolean check() throws IOException, TesseractException {
      //  String  = "/Users/sohyun/Downloads/demo (3)/demo/src/main/java/com/kurly/demo/image/102.png";
        String answer = "402";
      //  String answer = "";

        URI imageUri = null;
        return ocrCheckService.check(imageUri, answer);
    }
}
