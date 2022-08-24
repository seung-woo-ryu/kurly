package com.kurly.demo.deliveryCheck.service;

import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class OcrCheckService {

    public boolean check(URI imageUri , String answer) throws IOException { // imageDir(이미지 전체경로), answer(비교할 호수)

        String result = "";

        System.setProperty("jna.library.path", "/usr/local/lib");

        Tesseract tesseract = new Tesseract();

        tesseract.setDatapath("java/com/kurly/demo/image");
        tesseract.setTessVariable("tessedit_char_whitelist", "0123456789");
        tesseract.setLanguage("eng");

        try {
            // BufferedImage bufferedImage = ImageIO.read(new File(String.valueOf(image)));

            String imageUrl = String.valueOf(imageUri.toURL());

            BufferedImage image;

            URL url = new URL(imageUrl);
            image = ImageIO.read(url);

            result = tesseract.doOCR(image);
            System.out.println(result);

        } catch (IOException | TesseractException e) {
            e.printStackTrace();
        }

        result = result.trim();
        if (result.equals(answer)) {
            return true;
        }
        else{
            return false;
        }
    }
}
