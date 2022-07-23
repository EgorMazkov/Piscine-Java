package edu.school21.printer.logic;

import com.beust.jcommander.JCommander;
import com.diogonunes.jcdp.color.ColoredPrinter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class ImageTransformation {
    private final BufferedImage image;
    String[] args;
    int x;
    int y;

    public ImageTransformation(InputStream image, String[] args) throws IOException {
        this.image = ImageIO.read(image);
        this.args = args;
        this.x = 0;
        this.y = 0;
    }

    public void transformation() {
        Args args1 = new Args();
        JCommander.newBuilder().addObject(args1).build().parse(this.args);
        ColoredPrinter black = new ColoredPrinter.Builder(1, false)
                .background(args1.getBlack()).build();
        ColoredPrinter white = new ColoredPrinter.Builder(1, false)
                .background(args1.getWhite()).build();
        for (; y != image.getHeight(); y++) {
            x = 0;
            for (; x != image.getWidth(); x++) {
                Color color = new Color(image.getRGB(x, y));
                if (color.equals(Color.BLACK)) {
                    black.print("  ");
                }
                if (color.equals(Color.WHITE)) {
                    white.print("  ");
                }
            }
            System.out.println();
        }
    }
}
