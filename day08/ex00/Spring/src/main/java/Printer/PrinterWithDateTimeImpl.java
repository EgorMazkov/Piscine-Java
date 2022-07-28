package Printer;

import Renderer.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{
    private Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void printMessage(String message) {
        renderer.render("[" + LocalDateTime.now() + "]" + message);
    }

}
