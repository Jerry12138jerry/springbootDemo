package com.jerry.picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Jerry
 * @date 2018/10/11
 * 描述：
 */
public class test {

    public static void main(String[] args) throws IOException {

        final String picType = "jpg";

        final File file = new File("C:/Users/DELL/Downloads/test2.jpg");

        //图片缓冲流
        BufferedImage bi = null;

        File image = new File("C:\\Users\\DELL\\Downloads\\test.jpg");

        bi = ImageIO.read(image);

        Graphics graphics = bi.createGraphics();

        graphics.setColor(Color.GREEN);

        graphics.fillRect(100,100,5,5);
        graphics.dispose();
        try {
            ImageIO.write(bi, picType, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}