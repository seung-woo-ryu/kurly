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

@Service
@RequiredArgsConstructor
public class OcrCheckService {

    public boolean check(String imageDir, String answer) { // imageDir(이미지 전체경로), answer(비교할 호수)

        String result = "";

        System.setProperty("jna.library.path", "/usr/local/lib");

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/Users/sohyun/Downloads/demo (3)/demo/src/main/java/com/kurly/demo/image");
        tesseract.setTessVariable("tessedit_char_whitelist", "0123456789");
        tesseract.setLanguage("eng");


        try {
//            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
//            ColorConvertOp op = new ColorConvertOp(cs, null);

//            BufferedImage bufferedImage = ImageIO.read(new File("/Users/sohyun/Downloads/demo (3)/demo/src/main/java/com/kurly/demo/image/519.png"));
            BufferedImage bufferedImage = ImageIO.read(new File(imageDir));
//            bufferedImage = op.filter(bufferedImage, null);



            result = tesseract.doOCR(bufferedImage);
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
