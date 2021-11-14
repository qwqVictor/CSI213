/**
 * Driver to test
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class Driver {
    public static void main(String args[]) {
        Helper.start(args.length > 1 && args[1].equals("--debug"));
    }
}
