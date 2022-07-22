package edu.school21.printer.app;

import edu.school21.printer.logic.ImageTransformation;

import java.io.IOException;
import java.io.InputStream;


public class Program {
    public static void main(String[] args) throws IOException {
        String symbolInsteadOfBlack;
        String symbolInsteadOfWhite;
        String pathImage;
        InputStream image;

        if (args.length != 2 || !args[0].startsWith("--black=") || !args[1].startsWith("--white=")) {
            System.out.println("java -classpath target edu.school21.printer.app.Program --black=<symbol> --white=<symbol>");
            System.exit(-1);
        }

        symbolInsteadOfBlack = args[0].substring("--black=".length());
        symbolInsteadOfWhite = args[1].substring("--white=".length());

        if (symbolInsteadOfBlack.length() != 1 || symbolInsteadOfWhite.length() != 1) {
            System.out.println("Error: the number of characters exceeds one");
            System.exit(-1);
        }

        image = Program.class.getClassLoader().getResourceAsStream("src/resources/it.bmp");

        if (image == null) {
            System.out.println("Error: file null");
            System.exit(-1);
        }
        ImageTransformation transformation = new ImageTransformation(image, symbolInsteadOfBlack, symbolInsteadOfWhite);
        transformation.transformation();
    }
}
