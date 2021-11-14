import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 */
public class IteratorLab {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // read numbers from stdin
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        // iterate
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer value = it.next();
            it.remove();
            System.out.printf("Poped value: %d, current size: %d\n", value, list.size());
        }
    }
}