package Group2Player;

public class QueueOutOfBoundException extends RuntimeException {
    public QueueOutOfBoundException() {
        super("Accessing out of bound value");
    }
    public QueueOutOfBoundException(String message) {
        super(message);
    }
}
