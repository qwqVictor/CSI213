import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
/**
* Helper for testing purpose only
* @author Huang Kaisheng <2020215138@stu.cqupt.edu.cn>
* @version 1.0
*/
public class Helper {
    
    public static void start() {
        ADTBag bag = new ADTBag(100);
        try {
            create(bag);
            display(bag);

            // fill the bag
            for (int i = bag.size(); i < 100; i++) {
                bag.insert("test" + i);
            }

            /* start to test inserting when it's full. */
            try {
                bag.insert("exceed?");
            } catch (FullADTBagException e) {
                System.err.println("[Exception testing] reached " + e.getMessage() + "!");
            }

            /* start to test getting inserting when it's full. */
            try {
                System.out.println(bag.get(1));
                System.out.println(bag.get("test100"));
                System.out.println(bag.get(100));
            } catch (BagIndexOutOfBoundException e) {
                System.err.println("[Exception testing] reached " + e.getMessage() + "!");
            }

            /* clear the bag */
            if (!bag.isEmpty())
                bag.makeEmpty();
            
            /* start to test removing when it's empty */
            try {
                bag.removeRandom();
            } catch (EmptyADTBagException e) {
                System.err.println("[Exception testing] reached " + e.getMessage() + "!");
            }
        } catch(IOException ioException) {
            System.err.println("I/O Exception occurs.");
        }
    }

    public static void create(ADTBag bag) throws IOException {
        FileReader file = new FileReader("./testdata.txt");
        BufferedReader input = new BufferedReader(file);
        String line;
        while ( (line = input.readLine()) != null && line.length() != 0 ) {
            bag.insert(line);
        }
    }

    public static void display(ADTBag bag) {
        System.out.println("Items in bag: ");
        for (int i = 0; i < bag.size(); i++) {
            System.out.printf("%d\t: %s\n", i, bag.get(i).toString());
        }
    }
}