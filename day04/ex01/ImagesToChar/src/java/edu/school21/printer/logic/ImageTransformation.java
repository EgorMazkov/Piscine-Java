package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

public class ImageTransformation {
    private BufferedImage image;
    String symbolInsteadOfBlack;
    String symbolInsteadOfWhite;
    int x;
    int y;

    public ImageTransformation(InputStream image, String symbolInsteadOfBlack, String symbolInsteadOfWhite) throws IOException {
        this.image = ImageIO.read(image);
        this.symbolInsteadOfBlack = symbolInsteadOfBlack;
        this.symbolInsteadOfWhite = symbolInsteadOfWhite;
        this.x = 0;
        this.y = 0;
    }

    public void transformation() {
        for (; y != image.getHeight(); y++) {
            x = 0;
            for (; x != image.getWidth(); x++) {
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
