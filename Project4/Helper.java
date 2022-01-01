import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Helper class for testing purpose only
 * 
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class Helper {
    static void testTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(114);
        tree.insert(514);
        tree.insert(1919810);
        System.err.println(tree.isEmpty());
        for (Integer i : tree) {
            System.out.println(i);
        }
    }

    static void testAddressBook() {
        AddressBook addressBook = new AddressBook();
        try {
            FileReader file = new FileReader("./testdata.txt");
            BufferedReader input = new BufferedReader(file);
            String line;
            while ((line = input.readLine()) != null && line.length() != 0) {
                String[] tokens = line.split("\t");
                addressBook.insert(new Contact(tokens[0], tokens[1],
                        new Address(tokens[2], tokens[3], tokens[4], tokens[5]), tokens[6]));
            }
            System.out.println("Test contacts retrieving city San Jose: ");
            for (Contact contact : addressBook.getContactByCity("San Jose")) {
                System.out.println(contact);
            }
            System.out.println("Test contacts retrieving zipCode 99501:");
            for (Contact contact : addressBook.getContactByZipCode(99501)) {
                System.out.println(contact);
            }
            System.out.println("Test contacts retrieving area code 907: ");
            for (Contact contact : addressBook.getContactByAreaCode(907)) {
                System.out.println(contact);
            }

            input.close();
        } catch (IOException e) {
            System.err.println("Test error. IOException: " + e.getMessage());
        }
    }

    public static void start(boolean treeOnly) {
        if (treeOnly) {
            testTree();
        } else {
            testAddressBook();
        }
    }
}
