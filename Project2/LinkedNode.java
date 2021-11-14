/**
 * Declarationo of node in the linked list
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class LinkedNode<T> {
    public T value;
    public LinkedNode<T> prev, next;

    /**
     * Constructor to make a node by just set the value
     * @param value the value to be set
     */
    public LinkedNode(T value) { this.value = value; prev = null; next = null; }
    
    /**
     * Copy constructor to clone only the value
     * @param node the node to be cloned
     */
    public LinkedNode(LinkedNode<T> node) { this.value = node.value; }
}