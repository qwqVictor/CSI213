/**
 * Thrown from the stack
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class StackException extends RuntimeException {
    public StackException() { super(); }
    public StackException(String message) {
        super("Stack exception: " + message);
    }

}
