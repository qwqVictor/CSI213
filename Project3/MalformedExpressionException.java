/**
 * Thrown when processing a malformed expression
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class MalformedExpressionException extends RuntimeException {
    public MalformedExpressionException() { super(); }
    public MalformedExpressionException(String message) {
        super("Evaluating a malformed expression: " + message);
    }
}
