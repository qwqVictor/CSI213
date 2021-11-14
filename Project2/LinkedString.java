/**
 * Implemented string by using linked list
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class LinkedString implements LinkedStringInterface {
    private LinkedNode<Character> head = null;
    private int _length = 0;

    /**
     * Constructor to make an empty linked string
     */
    private LinkedString() {}

    /**
     * Constructor to make a linked string from a primitive character array
     * @param array the array which linked string builds from
     */
    public LinkedString(char[] array) {
        LinkedNode<Character> prev = null, current = null;
        for (int i = 0; i < array.length; i++) {
            current = new LinkedNode<Character>(array[i]);
            if (prev != null) {
                prev.next = current;
                current.prev = prev;
            }
            else {
                this.head = current;
            }
            prev = current;
            current = current.next;
        }
        this._length = array.length;
    }

    /**
     * Constructor to make a linked string from a string
     * @param str the string which linked string builds from
     */
    public LinkedString(String str) {
        this(str.toCharArray());
    }

    /**
     * Get a character by index
     * @param index the index of wanted character
     * @return the wanted character
     * @throws StringIndexOutOfBoundsException thrown when the index is out of bound
     */
    public char charAt(int index) throws LinkedStringIndexOutOfBoundsException {
        LinkedNode<Character> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
            if (current == null) throw new LinkedStringIndexOutOfBoundsException();
        }
        return current.value.charValue();
    }

    /**
     * Concatenate two linked strings
     * @param other the latter string 
     * @return the concatenated linked string
     */
    public LinkedString concat(LinkedString other) {
        LinkedString ret = new LinkedString();
        LinkedNode<Character> prev = null, current = null, iterateNode = this.head;
        boolean jumped = false;
        while (iterateNode != null) {
            current = new LinkedNode<Character>(iterateNode);
            this._length++;
            if (prev != null) {
                prev.next = current;
                current.prev = prev;
                prev = current;
                if (iterateNode.next == null && (!jumped)) {
                    iterateNode = other.head;
                    jumped = true;
                    continue;
                }
            }
            else {
                prev = current;
                ret.head = current;
            }
            iterateNode = iterateNode.next;
        }
        return ret;
    }

    /**
     * Figure out if the linked string is empty
     * @return true for empty, false for not empty
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * Get the length of the linked string
     * @return the length
     */
    public int length() {
        return this._length;
    }

    /**
     * Get a substring of the linked string
     * @param begin the begin index, included in the string
     * @param end the end index, not included in the string
     * @return sliced substring
     */
    public LinkedString substring(int begin, int end) {
        LinkedString ret = new LinkedString();
        LinkedNode<Character> prev = null, current = null, iterateNode = this.head;
        if (begin >= this._length || begin < 0 || begin >= end) return ret;
        for (int i = 0; i < begin; i++) iterateNode = iterateNode.next;
        for (int i = begin; i < end && iterateNode != null; i++) {
            current = new LinkedNode<Character>(iterateNode);
            ret._length++;
            if (prev != null) {
                prev.next = current;
                current.prev = prev;
            }
            else {
                ret.head = current;
            }
            prev = current;
            iterateNode = iterateNode.next;
        }
        return ret;
    }

    /**
     * Returns a string representation of the the linked string.
     * @return the string representation of the linked string.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        LinkedNode<Character> current = this.head;

        while (current != null) {
            builder.append(current.value);
            current = current.next;
        }

        return builder.toString();
    }
}