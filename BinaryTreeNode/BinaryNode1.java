package BinaryTreeNode;

public class BinaryNode1<E>  {
	private E element;          // an element stored at this node
    private BinaryNode1<E> parent;     // a reference to the parent node (if any)
    private BinaryNode1<E> left;       // a reference to the left child (if any)
    private BinaryNode1<E> right;      // a reference to the right child (if any)

    /**
     * Constructs a node with the given element and neighbors.
     *
     * @param e  the element to be stored
     * @param above       reference to a parent node
     * @param leftChild   reference to a left child node
     */
    public BinaryNode1(E e, BinaryNode1<E> above, BinaryNode1<E> leftChild, BinaryNode1<E> rightChild) {
      element = e;
      parent = above;
      left = leftChild;
      right = rightChild;
    }

    // accessor methods
    public E getElement() { return element; }
    public BinaryNode1<E> getParent() { return parent; }
    public BinaryNode1<E> getLeft() { return left; }
    public BinaryNode1<E> getRight() { return right; }

    // update methods
    public void setElement(E e) { element = e; }
    public void setParent(BinaryNode1<E> parentNode) { parent = parentNode; }
    public void setLeft(BinaryNode1<E> leftChild) { left = leftChild; }
    public void setRight(BinaryNode1<E> rightChild) { right = rightChild; }


}
