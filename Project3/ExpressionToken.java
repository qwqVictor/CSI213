/**
 * The tokens that an expression consists of, can be number or operator
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class ExpressionToken {
    private double value;
    private Operator operator;

    /**
     * The constructor that takes a real number to create a numeric token
     * @param v the real numeric value
     */
    public ExpressionToken(double v) {
        this.value = v;
        this.operator = null;
    }

    /**
     * The constructor to create a token from its string representation
     * @param token the token string to be converted
     */
    public ExpressionToken(String token) {
        this.value = Double.NaN;
        switch(token.charAt(0)) {
            case '+':
                this.operator = Operator.Add;
                break;
            case '-':
                this.operator = Operator.Minus;
                break;
            case '*':
                this.operator = Operator.Multiply;
                break;
            case '/':
                this.operator = Operator.Divide;
                break;
            case '(':
                this.operator = Operator.LeftParen;
                break;
            case ')':
                this.operator = Operator.RightParen;
                break;
            default:
                this.value = Double.parseDouble(token);
                this.operator = null;
                break;
        }
    }

    /**
     * Get the numeric value
     * @return the numeric value. NaN if it's an operator.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Get the operator enumeration constant
     * @return the operator. Null if it's a number.
     */
    public Operator getOperator() {
        return this.operator;
    }

    /**
     * Check if it's an operator
     * @return
     */
    public boolean isOperator() {
        return Double.isNaN(this.value);
    }

    /**
     * Get the precedence of the operator
     * @return the precedence of the operator. -1 if it's not an operator
     */
    public int getPrecedence() {
        switch (this.operator) {
            case Add:
            case Minus:
                return 10;
            case Multiply:
            case Divide:
                return 20;
            case LeftParen:
                return 0;
            case RightParen:
                return 0;
        }
        return -1;
    }

    /**
     * Calculate using the operator
     * @param operand1 the first operand
     * @param operand2 the second operand
     * @return the result of calculation. If it's a number, self will be returned.
     */
    public double calc(ExpressionToken operand1, ExpressionToken operand2) {
        double a = operand1.getValue(), b = operand2.getValue();
        switch (this.operator) {
            case Add:
                return a + b;
            case Minus:
                return a - b;
            case Multiply:
                return a * b;
            case Divide:
                return a / b;
            default:
                return this.value;
        }
    }

    /**
     * Get the string representation of the token
     * @return the string representation of the token
     */
    public String toString() {
        if (this.operator != null) {
            switch (this.operator) {
                case Add:
                    return "+";
                case Minus:
                    return "-";
                case Multiply:
                    return "*";
                case Divide:
                    return "/";
                case LeftParen:
                    return "(";
                case RightParen:
                    return ")";
                default:
                    return "";
            }
        }
        else {
            return String.valueOf(this.value);
        }
    }
}
