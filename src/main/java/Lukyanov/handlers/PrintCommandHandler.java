package Lukyanov.handlers;

import Lukyanov.util.MyUtil;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PrintCommandHandler implements ActionHandler {
    private Pattern pattern;
    @Override
    public void handle(String cmd) {
        pattern = Pattern.compile("^(\\b(print)\\b)(\\s)((\\d)(\\s))?(\\w)*(\\.txt)$");
        if (pattern.matcher(cmd).matches()) {
            Scanner scanner = new Scanner(cmd).useDelimiter(" ");
            scanner.next();
            int lineNumber = 0;
            try {
                lineNumber = scanner.nextInt();
                System.out.println("Print line #" + lineNumber);
            } catch (NoSuchElementException e) {
                System.out.println("Printed whole file:");
                String fileName = scanner.next();
                MyUtil.printFileToConsole("D:/Users/1/Desktop/"+fileName);
            }
        }
    }
}
