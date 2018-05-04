package org.zerhusen;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class ScreenShot {
    private String imagepath = "";
    private String imageInString = "";
    private BufferedImage image;
    private byte[] byteArray;
    private File file;

    public ScreenShot() {
        System.setProperty("java.awt.headless", "false");
        imagepath = "C:\\Users\\User\\Desktop\\" + new Date().getTime() + "serverscreenshot.png";
        file = new File(imagepath);

        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", file);
            BufferedImage bufferedImage = ImageIO.read(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg",baos);
            baos.flush();
            byteArray=baos.toByteArray();
            baos.close();
        } catch (HeadlessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String getImagepath() {
        return imagepath;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getImageInString() {
        return imageInString;
    }

    public byte[] getByteArray() {
        return byteArray;
    }

    public File getFile() {
        return file;
    }
}
