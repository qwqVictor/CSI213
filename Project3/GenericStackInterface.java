/**
 * Interface which define a stack should implement
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public interface GenericStackInterface<E> {
    void push(E element);
    E pop();
    void popAll();
    E peek();
    boolean isEmpty();
    int size();
}
