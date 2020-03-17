package Lukyanov.exceptions;

public class CommandNotFoundException extends RuntimeException {
    public CommandNotFoundException(String msg) {
        super(msg);
    }
}
