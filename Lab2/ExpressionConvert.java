import java.util.Scanner;
import java.util.ArrayList;

public class ExpressionConvert {

    public static String toPostfix(String expr) {
        GenericStack<String> stack = new GenericStack<String>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);
            if (Character.isDigit(ch) || (ch == '-' && i == 0)) {
                
            }
        }
        return 
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        String result = toPostfix(expr);
        
    }
}