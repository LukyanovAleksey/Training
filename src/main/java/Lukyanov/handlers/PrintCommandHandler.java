package Lukyanov.handlers;

import Lukyanov.exceptions.WrongCommandFormatException;
import Lukyanov.util.MyUtil;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
Used to print new lines in file
Available type of commands:
print 5 fileName
print fileName
 */

public class PrintCommandHandler implements ActionHandler {
    private Pattern pattern;
    @Override
    public void handle(String cmd) {
        pattern = Pattern.compile("^(\\b(print)\\b)(\\s)((\\d*)(\\s))?([\\w:/])*(\\.txt)$");
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
            List<String> lines = MyUtil.readFileToList(fileName);
            if (hasLineNumber) {
                System.out.println(lines.get(lineNumber-1));
            } else {
                MyUtil.printFileToConsole(fileName);
            }
        } else throw new WrongCommandFormatException("Wrong format! Use format:\n" +
                "\"print {lineNumber} fileName\" instead of:\n" +
                cmd);
    }
}
