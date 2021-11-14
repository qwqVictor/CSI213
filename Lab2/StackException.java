public class StackException extends RuntimeException {
    public StackException() { super(); }
    public StackException(String message) {
        super("Stack exception: " + message);
    }

}
