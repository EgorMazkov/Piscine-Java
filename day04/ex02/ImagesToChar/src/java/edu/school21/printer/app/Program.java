package edu.school21.printer.app;


import edu.school21.printer.logic.ImageTransformation;
import java.io.IOException;
import java.io.InputStream;

public class Program {
    public static void main(String[] args) throws IOException {
        InputStream image = null;


        if (args.length != 2 || !args[0].startsWith("--white=") || !args[1].startsWith("--black=")) {
            System.out.println("java -classpath target edu.school21.printer.app.Program --black=<symbol> --white=<symbol>");
            System.exit(-1);
        }

        try {
            image = Program.class.getClassLoader().getResourceAsStream("resources/image.bmp");
            ImageTransformation transformation = new ImageTransformation(image, args);
            transformation.transformation();
        }
        catch (IllegalArgumentException e) {
            System.out.println("Exception: image returned null");
            e.getMessage();
        }

    }

}

