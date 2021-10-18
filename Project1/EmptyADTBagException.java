import java.lang.RuntimeException;
/**
* Indicate an exception that the bag is empty
* @author Huang Kaisheng <2020215138@stu.cqupt.edu.cn>
* @version 1.0
*/
public class EmptyADTBagException extends RuntimeException {
    public EmptyADTBagException() {
        super("Bag is empty");
    }
}
