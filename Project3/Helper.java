import java.util.Scanner;
/**
 * Helper to test
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class Helper {
    public static void start(boolean debug) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Expression expr = new Expression(scanner.nextLine());
            if (debug)
                System.err.println("Postfix: " + expr);
            System.out.println(expr.eval());
        }
    }
}
