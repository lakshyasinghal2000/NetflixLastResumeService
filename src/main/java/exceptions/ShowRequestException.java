package exceptions;

public class ShowRequestException extends RuntimeException{
    public ShowRequestException(String message) {
        super(message);
    }
}
