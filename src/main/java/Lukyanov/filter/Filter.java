package lukyanov.filter;

import lukyanov.exceptions.CommandNotFoundException;
import lukyanov.exceptions.WrongCommandFormatException;
import lukyanov.handlers.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Filter {

    private HashMap<String, ActionHandler> cmdToActionMap;
    private Pattern pattern;

    public Filter() {
        pattern = Pattern.compile("((add)|(print)|(delete)|(exit)|(help)).*");
        cmdToActionMap = new HashMap<>();
        cmdToActionMap.put("add", new AddCommandHandler());
        cmdToActionMap.put("delete", new DeleteCommandHandler());
        cmdToActionMap.put("print", new PrintCommandHandler());
        cmdToActionMap.put("exit", new ExitCommandHandler());
        cmdToActionMap.put("help", new HelpCommandHandler());
    }

    public void execute(String command) {
        if (pattern.matcher(command).matches()) {
            try (Scanner scanner = new Scanner(command)) {
                scanner.useDelimiter(" ");
                cmdToActionMap.get(scanner.next()).handle(command);
            } catch (WrongCommandFormatException e) {
                System.out.println(e.getMessage());
            }
        } else throw new CommandNotFoundException("Wrong command!");
    }
}
