import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Expression class that can store and evaluate an expression consists of addition, subtraction, multiplication and division
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class Expression {
    private String infix;
    private ArrayList<ExpressionToken> postfix;
    private double cachedValue;

    /**
     * The default constructor
     */
    Expression() {
        this.infix = null;
        this.postfix = null;
        this.cachedValue = Double.NaN;
    }
    
    /**
     * The constructor which takes an expression as parameter
     * @param expr the expression to be set
     */
    Expression(String expr) {
        this.setInfix(expr);
    }

    /**
     * Convert an infix expression to postfix
     * @param expr the infix to be converted
     * @return the postfix form of expression
     */
    private ArrayList<ExpressionToken> toPostfix(String expr) {
        GenericStack<ExpressionToken> stack = new GenericStack<ExpressionToken>();
        StringTokenizer tokenizer = new StringTokenizer(expr, "+-*/()", true);
        ArrayList<ExpressionToken> array = new ArrayList<ExpressionToken>(tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            ExpressionToken token = new ExpressionToken(tokenizer.nextToken());
            if (token.isOperator()) {
                if (token.getOperator() == Operator.LeftParen) {
                    stack.push(token);
                }
                else if (token.getOperator() != Operator.RightParen) {
                    if (!stack.isEmpty()) {
                        while (!stack.isEmpty() && stack.peek().getOperator() != Operator.LeftParen) {
                            if (stack.peek().getPrecedence() >= token.getPrecedence()) {
                                array.add(stack.pop());
                            }
                            else break;
                        }
                    }
                    stack.push(token);
                }
                else {
                    while (!stack.isEmpty() && stack.peek().getOperator() != Operator.LeftParen)
                        array.add(stack.pop());
                    if (!stack.isEmpty() && stack.peek().getOperator() == Operator.LeftParen)
                        stack.pop();
                }
            }
            else
                array.add(token);
        }
        while (!stack.isEmpty())
            array.add(stack.pop());
        return array;
    }

    /**
     * Evaluate the expression
     * @return the result of expression
     * @throws MalformedExpressionException thrown when the expression is invalid
     */
    public double eval() throws MalformedExpressionException {
        if (this.postfix == null || (this.postfix != null && this.postfix.size() == 0))
            throw new MalformedExpressionException("Refuse to evaluate an empty expression");
        GenericStack<ExpressionToken> stack = new GenericStack<ExpressionToken>();
        for (ExpressionToken token : this.postfix) {
            if (token.isOperator()) {
                if (stack.size() < 2) {
                    throw new MalformedExpressionException("Missing operand");
                }
                ExpressionToken b = stack.pop();
                ExpressionToken a = stack.pop();
                stack.push(new ExpressionToken(token.calc(a, b)));
            }
            else {
                stack.push(token);
            }
        }
        return stack.pop().getValue();
    }

    /**
     * Set the infix expression
     * @param expr the expression to be set
     */
    public void setInfix(String expr) {
        this.infix = expr.replace(" ", "");;
        this.postfix = this.toPostfix(this.infix);
        this.cachedValue = Double.NaN;
    }

    /**
     * Get the infix expression
     * @return The string representation of infix expression
     */
    public String getInfix() {
        return this.infix;
    }

    /**
     * Get the postfix expression
     * @return The tokenized list that represents the postfix expression
     */
    public ArrayList<ExpressionToken> getPostfix() {
        return this.postfix;
    }

    /**
     * Get the string representation of the expression.
     * @return The postfix string representation of the expression
     */
    public String toString() { return this.toString(true); }

    /**
     * Get the string representation of the expression.
     * @param postfix indicates if use the postfix string representation
     * @return The infix or postfix string representation of the expression
     */
    public String toString(boolean postfix) {
        if (postfix) {
            StringBuilder builder = new StringBuilder();
            for (ExpressionToken token : this.postfix) {
                builder.append(token + " ");
            }
            return builder.toString();
        }
        else {
            return this.infix;
        }
    }

    /**
     * Judge if the expression is equal to another one
     * @param expr Another expression
     * @return the equality between two expressions
     */
    public boolean equals(Expression expr) {
        try {
            if (Double.isNaN(this.cachedValue))
                this.cachedValue = this.eval();
            if (Double.isNaN(expr.cachedValue))
                expr.cachedValue = expr.eval();
            return this.cachedValue == expr.cachedValue;
        } catch (MalformedExpressionException e) {
            return false;
        }
    }
}