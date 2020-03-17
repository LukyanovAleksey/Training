package Lukyanov.handlers;

import java.util.Scanner;
import java.util.regex.Pattern;

public class AddCommandHandler implements ActionHandler {
    private Pattern pattern;
    @Override
    public void handle(String cmd) {
        pattern = Pattern.compile("^(\\b(add)\\b)(\\s)((\\d)(\\s))?(\\w)*(\\.txt)(\\s)(\"[\\w ]*\")$");
        if (pattern.matcher(cmd).matches()) {
            Scanner scanner = new Scanner(cmd).useDelimiter(" ");
            scanner.next();
            int lineNumber = 0;
            boolean hasLineNumber = scanner.hasNextInt();
            if (hasLineNumber) {
                lineNumber = scanner.nextInt();
            }
            String fileName = scanner.next();
            String text = scanner.findInLine("\"[\\w ]*\"");
            System.out.println(text);
        }
    }
}
