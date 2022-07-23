package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
public class ImageTransformation {
    private BufferedImage image;
    String symbolInsteadOfBlack;
    String symbolInsteadOfWhite;
    int x;
    int y;

    public ImageTransformation(BufferedImage image, String symbolInsteadOfBlack, String symbolInsteadOfWhite) {
        this.symbolInsteadOfBlack = symbolInsteadOfBlack;
        this.symbolInsteadOfWhite = symbolInsteadOfWhite;
        this.image = image;
        this.x = 0;
        this.y = 0;
    }

    public ImageTransformation(InputStream image, String symbolInsteadOfBlack, String symbolInsteadOfWhite) {
    }

    public void transformation() {
        for (; y < image.getHeight(); y++) {
            x = 0;
            for (; x < image.getWidth(); x++) {
                Color color = new Color(image.getRGB(x, y));
                if (color.equals(Color.BLACK)) {
                    System.out.print(symbolInsteadOfBlack);
                }
                if (color.equals(Color.WHITE)) {
                    System.out.print(symbolInsteadOfWhite);
                }
            }
            System.out.println();
        }
    }
}
