package lukyanov.handlers;

import lukyanov.exceptions.WrongCommandFormatException;

import java.util.regex.Pattern;

public class ExitCommandHandler implements ActionHandler {
    private Pattern pattern;

    @Override
    public void handle(String cmd) {
        pattern = Pattern.compile("^(\\b(exit)\\b)$");
        if (pattern.matcher(cmd).matches()) {
            System.out.println("You have successfully quit program");
            System.exit(0);
        } else throw new WrongCommandFormatException("Wrong format! Use format:\n" +
                "\"exit\" instead of:\n" +
                cmd);
    }
}
