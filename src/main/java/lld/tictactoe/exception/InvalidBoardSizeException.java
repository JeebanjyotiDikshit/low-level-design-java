package lld.tictactoe.exception;

public class InvalidBoardSizeException extends RuntimeException {
    public InvalidBoardSizeException(String message) {
        super(message);
    }
}
