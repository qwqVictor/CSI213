/**
 * @author Huang Kaisheng (2020215138@stu.cqupt.edu.cn)
 * @version 1.0
 */
public class TreeNode<T> {

	public T value;
	public TreeNode<T> left, right;

	/**
	 * Constructs an empty node.
	 */
	public TreeNode() {
		this(null, null, null);
	}

	/**
	 * Constructs a node with value.
	 * 
	 * @param value the value of the node
	 */
	public TreeNode(T value) {
		this(value, null, null);
	}

	/**
	 * Constructs a node with value and two childs.
	 * 
	 * @param value the value of the node
	 * @param left  the left child
	 * @param right the right child
	 */
	public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	/**
	 * Returns the value of this node.
	 * 
	 * @return A reference to the value of this node
	 */
	public T getValue() {
		return this.value;
	}
}
