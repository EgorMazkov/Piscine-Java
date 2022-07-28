package App;

import PreProcessor.*;
import Printer.*;
import Renderer.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Renderer renderer = new RendererErrImpl(preProcessor);
        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
        printer.setPrefix("Prefix");
        printer.printMessage("Hello!");

        System.out.println("-----------------------------------------------------------------------");
        ApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        Printer printerOne = context.getBean("PrinterWithPrefixImpl", Printer.class);
        printerOne.printMessage("Hello!");
    }
}
