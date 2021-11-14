import java.util.Random;

/**
* Representing a bag that is like a storage of grocery items and a set of operations on the storage
* @author Huang Kaisheng <2020215138@stu.cqupt.edu.cn>
* @version 1.0
*/
public class ADTBag implements ADTInterface {
    private Object[] storage;
    private Random randomizer;
    private int itemCount;
    private int capacity;

    /**
     * constructor
     * @param capacity initial capacity to allocate for ArrayList
     */
    public ADTBag(int capacity) {
        this.storage = new Object[capacity];
        this.randomizer = new Random();
        this.itemCount = 0;
        this.capacity = capacity;
    }

    /**
     * Insert an item to the ADTBag
     * @param item the item to be inserted
     */
    public void insert(Object item) {
        if (this.size() >= capacity)
            throw new FullADTBagException();
        this.storage[this.itemCount++] = item;
    }

    /**
     * Remove an item of the ADTBag by index
     * @param index the index to remove
     * @return the item that is just removed
     */
    public Object remove(int index) throws EmptyADTBagException, BagIndexOutOfBoundException {
        if (this.isEmpty())
            throw new EmptyADTBagException();
        if (index >= this.size())
            throw new BagIndexOutOfBoundException(index);
        Object removedObject = this.storage[index];
        for (int i = index + 1; i < itemCount; i++) {
            this.storage[i - 1] = this.storage[i];
        }
        itemCount--;
        this.storage[itemCount] = null;
        return removedObject;
    }

    /**
     * Remove the last item of the ADTBag
     * @return the item that is just removed
     */
    public Object removeLast() {
        return this.remove(this.size() - 1);
    }

    /**
     * Remove a item which is randomly chosen of the ADTBag
     * @return the item that is just removed
     */
    public Object removeRandom() {
        return this.remove(this.size() > 0 ? randomizer.nextInt(this.size()) : 0);
    }

    /**
     * Get the index of an existing item
     * @param item the item to get its index
     * @return the first occurence index of the specified item. 
     *         -1 will be returned if not exist.
     */
    public int get(Object item) {
        int index = -1;
        for (int i = 0; i < itemCount; i++) {
            try {
                if (this.storage[i].equals(item)) {
                    index = i;
                    break;
                }
            } catch (RuntimeException e) {
                continue;
            }
        }
        return index;
    }

    /**
     * Get item by index
     * @param index the index of wanted item
     * @return the specified item
     */
    public Object get(int index) throws BagIndexOutOfBoundException {
        if (index >= this.size() || index < 0)
            throw new BagIndexOutOfBoundException(index);
        return this.storage[index];
    }

    /**
     * Get the size of ADTBag
     * @return the size of ADTBag
     */
    public int size() {
        return itemCount;
    }

    /**
     * Check if the bag is empty
     * @return if the bag is empty
     */
    public boolean isEmpty() {
        return this.itemCount == 0;
    }

    /**
     * Remove all items existed in the Bag
     */
    public void makeEmpty() {
        this.storage = new Object[this.capacity];
        this.itemCount = 0;
    }
}