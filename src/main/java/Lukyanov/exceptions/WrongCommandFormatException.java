package lukyanov.exceptions;

public class WrongCommandFormatException extends RuntimeException {
    public WrongCommandFormatException(String msg) {
        super(msg);
    }
}
