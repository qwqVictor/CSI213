import java.util.ArrayList;
/**
 * Just a generic FILO stack
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class GenericStack<E> implements GenericStackInterface<E> {
    private ArrayList<E> list;

    /**
     * Default constructor
     */
    public GenericStack() {
        this.list = new ArrayList<E>();
    }

    /**
     * Push an element to the top of stack
     * @param element the element to be pushed
     */
    public void push(E element) {
        this.list.add(element);
    }

    /**
     * Pop an element from the top of stack
     * @return the element to be poped
     */
    public E pop() throws StackException {
        if (this.isEmpty())
            throw new StackException("trying to pop an empty stack");
        return this.list.remove(this.size() - 1);

    }

    /**
     * Clear the stack
     */
    public void popAll() {
        this.list.clear();
    }

    /**
     * Get the top element of stack
     * @return the top element of stack
     */
    public E peek() {
        if (this.isEmpty())
            throw new StackException("trying to peek an empty stack");
        return this.list.get(this.size() - 1);
    }

    /**
     * Check if the stack is empty
     * @return if the stack is empty
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Get the element count of stack
     * @return the element count
     */
    public int size() {
        return this.list.size();
    }

}