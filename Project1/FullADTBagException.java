import java.lang.RuntimeException;
/**
* Indicate an exception that the bag is full
* @author Huang Kaisheng <2020215138@stu.cqupt.edu.cn>
* @version 1.0
*/
public class FullADTBagException extends RuntimeException {
    public FullADTBagException() {
        super("Unable to insert because the bag is full");
    }
}
