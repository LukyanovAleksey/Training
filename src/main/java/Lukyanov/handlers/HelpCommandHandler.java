package lukyanov.handlers;

import lukyanov.exceptions.WrongCommandFormatException;

import java.util.regex.Pattern;

public class HelpCommandHandler implements ActionHandler {
    private Pattern pattern;

    @Override
    public void handle(String cmd) {
        pattern = Pattern.compile("^(\\b(help)\\b)$");
        if (pattern.matcher(cmd).matches()) {
            System.out.println("Please use available commands:\n" +
                    "add {lineNumber} fileName \"text\"\n" +
                    "delete {lineNumber} fileName\n" +
                    "print {lineNumber} fileName\n" +
                    "help\n" +
                    "exit");
        } else throw new WrongCommandFormatException("Wrong format! Use format:\n" +
                "\"help\" instead of:\n" +
                cmd);
    }
}