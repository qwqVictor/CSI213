import java.lang.IndexOutOfBoundsException;
/**
* Indicate an exception of accessing index of element which is out of bound
* @author Huang Kaisheng <2020215138@stu.cqupt.edu.cn>
* @version 1.0
*/
public class BagIndexOutOfBoundException extends IndexOutOfBoundsException {
    public BagIndexOutOfBoundException() {}

    public BagIndexOutOfBoundException(int index) {
        super("Failed to access index " + index + " because it exceeds the bound");
    }
}
