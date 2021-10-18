/**
* The interface to declare what should be implemented
* @author Huang Kaisheng <2020215138@stu.cqupt.edu.cn>
* @version 1.0
*/
public interface ADTInterface {
    void insert(Object item);
    Object removeLast();
    Object removeRandom();
    int get(Object item);
    Object get(int index);
    int size();
    boolean isEmpty();
    void makeEmpty();
};