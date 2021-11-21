package Group2Player;

public class QueueNode<T> {
    T value;
    QueueNode<T> nextNode;

    public QueueNode(T value, QueueNode<T> nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public QueueNode(T value) {
        this(value, null);
    }

    public T getValue() { return this.value; }
    
    public QueueNode<T> getNextNode() {
        return this.nextNode; 
    }
    
    public void setNextNode(QueueNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
