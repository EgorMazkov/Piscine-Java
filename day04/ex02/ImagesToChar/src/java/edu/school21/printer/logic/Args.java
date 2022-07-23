package edu.school21.printer.logic;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.beust.jcommander.Parameters;
import com.diogonunes.jcdp.color.api.Ansi;

@Parameters(separators = "=")
public class Args implements IStringConverter {
    @Parameter(names = "--white")
    private Ansi.BColor white;
    @Parameter(names = "--black")
    private Ansi.BColor black;

    public Ansi.BColor getWhite() {
        return white;
    }

    public Ansi.BColor getBlack() {
        return black;
    }

    @Override
    public Object convert(String s) {

        switch (s) {
            case "BlACK":
                return Ansi.BColor.BLACK;
            case "RED":
                return Ansi.BColor.RED;
            case "GREEN":
                return Ansi.BColor.GREEN;
            case "YELLOW":
                return Ansi.BColor.YELLOW;
            case "BLUE":
                return Ansi.BColor.BLUE;
            case "MAGENTA":
                return Ansi.BColor.MAGENTA;
            case "CYAN":
                return Ansi.BColor.CYAN;
            case "WHITE":
                return Ansi.BColor.WHITE;
            case "NONE":
                return Ansi.BColor.NONE;
            default:
                throw new ParameterException("Exception: color null");
        }
    }
}
