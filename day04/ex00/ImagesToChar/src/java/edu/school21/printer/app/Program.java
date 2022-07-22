package edu.school21.printer.app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import edu.school21.printer.logic.ImageTransformation;


public class Program {
    public static void main(String[] args) throws IOException {
        String symbolInsteadOfBlack;
        String symbolInsteadOfWhite;
        String pathImage;
        BufferedImage image;

        if (args.length != 3 || !args[0].startsWith("--black=") || !args[1].startsWith("--white=") || !args[2].startsWith("--pathimage=")) {
            System.out.println("java -classpath target edu.school21.printer.app.Program --black=<symbol> --white=<symbol> --pathimage=<path>");
            System.exit(-1);
        }

        symbolInsteadOfBlack = args[0].substring("--black=".length());
        symbolInsteadOfWhite = args[1].substring("--white=".length());
        pathImage = args[2].substring("--pathImage=".length());

        if (symbolInsteadOfBlack.length() != 1 || symbolInsteadOfWhite.length() != 1) {
            System.out.println("Error: the number of characters exceeds one");
            System.exit(-1);
        }

        image = ImageIO.read(new File(pathImage));

        ImageTransformation transformation = new ImageTransformation(image, symbolInsteadOfBlack, symbolInsteadOfWhite);
        transformation.transformation();
    }
}
