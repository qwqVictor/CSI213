public interface GenericStackInterface<E> {
    void push(E element);
    E pop();
    void popAll();
    E peek();
    boolean isEmpty;
    int size();
}
