package Lukyanov.handlers;

import Lukyanov.exceptions.WrongCommandFormatException;
import Lukyanov.util.MyUtil;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
Used to add new lines in file
Available type of commands:
add 5 fileName "text"
add fileName "text"
 */

public class AddCommandHandler implements ActionHandler {
    private Pattern pattern;
    @Override
    public void handle(String cmd) {
        pattern = Pattern.compile("^(\\b(add)\\b)(\\s)((\\d*)(\\s))?([\\w:/])*(\\.txt)(\\s)(\".*\")$");
        if (pattern.matcher(cmd).matches()) {
            Scanner scanner = new Scanner(cmd).useDelimiter(" ");
            //skip command name
            scanner.next();
            int lineNumber = 0;
            boolean hasLineNumber = scanner.hasNextInt();
            //read line's position
            if (hasLineNumber) {
                lineNumber = scanner.nextInt();
                if (lineNumber < 1) throw new WrongCommandFormatException("Wrong number of line! It should be at least 1");
            }
            String fileName = scanner.next();
            String text = scanner.findInLine("\".*\"");
            text = text.replace("\"", "");

            List<String> lines = MyUtil.readFileToList(fileName);
            if (hasLineNumber) {
                if (lineNumber < lines.size()) {
                    lines.add(lineNumber-1, text);
                } else {
                    for (int i=lines.size(); i<lineNumber-1; i++) {
                        lines.add("");
                    }
                    lines.add(text);
                }
            } else {
                lines.add(text);
            }
            MyUtil.writeFromListToFile(fileName, lines);
            System.out.println("New line was successfully added!");
        } else {
            throw new WrongCommandFormatException("Wrong format! Use format:\n" +
                    "\"add {lineNumber} fileName \"text\"\" instead of:\n" +
                    cmd);
        }
    }
}
