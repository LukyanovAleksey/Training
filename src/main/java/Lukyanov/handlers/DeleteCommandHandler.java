package lukyanov.handlers;

import lukyanov.exceptions.WrongCommandFormatException;
import lukyanov.util.MyUtil;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Used to delete line in file
 * Available type of commands:
 * delete 5 fileName
 * delete fileName
 */
public class DeleteCommandHandler implements ActionHandler {
    private Pattern pattern;

    @Override
    public void handle(String cmd) {
        pattern = Pattern.compile("^(\\b(delete)\\b)(\\s)((\\d*)(\\s))?([\\w:/])*(\\.txt)$");
        if (pattern.matcher(cmd).matches()) {
            Scanner scanner = new Scanner(cmd).useDelimiter(" ");
            //skip command name
            scanner.next();
            int lineNumber = 0;
            boolean hasLineNumber = scanner.hasNextInt();
            //read line's position
            if (hasLineNumber) {
                lineNumber = scanner.nextInt();
                if (lineNumber < 1)
                    throw new WrongCommandFormatException("Wrong number of line! It should be at least 1");
            }
            String fileName = scanner.next();
            List<String> lines = MyUtil.readFileToList(fileName);
            if (hasLineNumber) {
                lines.remove(lineNumber - 1);
            } else {
                lines.remove(lines.size());
            }
            MyUtil.writeFromListToFile(fileName, lines);
            System.out.println("Line was successfully removed!");
        } else throw new WrongCommandFormatException("Wrong format! Use format:\n" +
                "\"delete {lineNumber} fileName\" instead of:\n" +
                cmd);
    }
}
