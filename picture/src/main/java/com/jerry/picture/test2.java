package com.jerry.picture;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * @author Jerry
 * @date 2018/10/11
 * 描述：
 * @description
 */
public class test2 {

    public static void main(String[] args) throws IOException {

        final String picType = "jpg";

        final File file = new File("C:/Users/DELL/Downloads/test3.jpg");

        File image = new File("C:\\Users\\DELL\\Downloads\\test.jpg");

        BufferedImage bi = ImageIO.read(image);

        BufferedImage bi2 = bi.getSubimage(100,100,100,100);

        ImageIO.write(bi2, picType, file);

    }

}
