package Group2Player;

public class BetterQueue<T> {
    private QueueNode<T> root;
    private QueueNode<T> last;
    private int qSize;

    public BetterQueue() {
        this.root = null;
        this.last = null;
        this.qSize = 0;
    }

    public T at(int index) throws QueueOutOfBoundException {
        QueueNode<T> ret = this.root;
        for (int i = 0; i < index; i++) {
            if (ret != null && ret.nextNode != null) {
                ret = ret.getNextNode();
            }
            else {
                throw new QueueOutOfBoundException("Index at " + i + " is out of bound.");
            }
        }
        return ret.getValue();
    }

    public T pop() throws QueueOutOfBoundException {
        QueueNode<T> ret = this.root;
        if (this.root != null) {
            this.root = this.root.getNextNode();
            if (ret == this.last) {
                this.last = this.root;
            }
            this.qSize--;
        }
        else {
            throw new QueueOutOfBoundException("Trying to pop an empty queue");
        }
        return ret.getValue();
    }

    public void push(T value) {
        QueueNode<T> newNode = new QueueNode<T>(value);
        if (last != null) {
            this.last.setNextNode(newNode);
        }
        else {
            this.root = newNode;
        }
        this.last = newNode;
        this.qSize++;
    }

    public int size() {
        return this.qSize;
    }

    public boolean isEmpty() {
        return this.root == null;
    }
}
