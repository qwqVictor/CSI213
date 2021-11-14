import java.util.ArrayList;

public class GenericStack<E> implements GenericStackInterface<E> {
    private ArrayList<E> list;

    public GenericStack() {
        this.list = new ArrayList<E>();
    }

    public void push(E element) {
        this.list.add(element);
    }

    public E pop() throws StackException {
        if (this.isEmpty())
            throw new StackException("trying to pop an empty stack");
        return this.list.remove(this.size() - 1);

    }

    public void popAll() {
        if (this.isEmpty())
            throw new StackException("trying to pop an empty stack");
        this.list.clear();
    }

    public E peek() {
        return this.list.get(this.size() - 1);
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.list.size();
    }

}