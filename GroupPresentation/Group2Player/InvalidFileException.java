package Group2Player;

public class InvalidFileException extends RuntimeException {
    public InvalidFileException() {
        super("The file is invalid.");
    }

    public InvalidFileException(String message) {
        super("File is invalid: " + message);
    }
}
