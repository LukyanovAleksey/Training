package Lukyanov.filter;

import Lukyanov.handlers.ActionHandler;
import Lukyanov.handlers.AddCommandHandler;
import Lukyanov.handlers.DeleteCommandHandler;
import Lukyanov.handlers.PrintCommandHandler;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Filter {

    private HashMap<String, ActionHandler> cmdToActionMap;
    private Pattern pattern;

    public Filter() {
        //commandName 4 fileName "text"
        pattern = Pattern.compile("(\\b(add|print|delete)\\b *[\\d]* *([\\w]+[\\w.]*) *(\"[\\w ]*\")?)|(exit)|(help)|(print)");
        cmdToActionMap = new HashMap<>();
        cmdToActionMap.put("add", new AddCommandHandler());
        cmdToActionMap.put("delete", new DeleteCommandHandler());
        cmdToActionMap.put("print", new PrintCommandHandler());
    }

    public void execute (String command){
        if (pattern.matcher(command).matches()) {
            try(Scanner scanner = new Scanner(command)) {
                scanner.useDelimiter(" ");
                cmdToActionMap.get(scanner.next()).handle(command);
            }
        }
    }
}
