package BinaryTreeNode;


public class myLinkedBinaryTree<E> {
	 protected BinaryNode1<E> root = null;     // root of the tree
	 protected int size = 0;              // number of nodes in the tree
	 
	 protected int rightSide = 0; 		// number of children on the right side
	 protected int leftSide = 0;		// number of children on the left side
	 protected int children = 0;		// number of children

	  // constructor
	  public myLinkedBinaryTree() {
		  root=null; 
		  size=0; 
		  }      // constructs an empty binary tree
	
	  protected BinaryNode1<E> validate(BinaryNode1<E> p) throws IllegalArgumentException {
		    if (!(p instanceof BinaryNode1))
		      throw new IllegalArgumentException("Not valid BinaryNode type");
		    BinaryNode1<E> node = (BinaryNode1<E>) p;       // safe cast
		    if (node.getParent() == node)     // our convention for defunct node
		      throw new IllegalArgumentException("p is no longer in the tree");
		    return node;
		  }

		  // accessor methods 
		  public int size() {
		    return size;
		  }

		  /**
		   * Returns the root BinaryNode of the tree (or null if tree is empty).
		   * @return root BinaryNode of the tree (or null if tree is empty)
		   */
		
		  public BinaryNode1<E> root() {
		    return root;
		  }

		  /**
		   * Returns the BinaryNode of p's parent (or null if p is root).
		   *
		   * @param p    A valid BinaryNode within the tree
		   * @return BinaryNode of p's parent (or null if p is root)
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree.
		   */
		  public BinaryNode1<E> parent(BinaryNode1<E> p) throws IllegalArgumentException {
			  BinaryNode1<E> node = validate(p);
		    return node.getParent();
		  }

		  /**
		   * Returns the BinaryNode of p's left child (or null if no child exists).
		   *
		   * @param p A valid BinaryNode within the tree
		   * @return the BinaryNode of the left child (or null if no child exists)
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
		   */
		  public BinaryNode1<E> left(BinaryNode1<E> p) throws IllegalArgumentException {
			  BinaryNode1<E> node = validate(p);
		    return node.getLeft();
		  }

		  /**
		   * Returns the BinaryNode of p's right child (or null if no child exists).
		   *
		   * @param p A valid BinaryNode within the tree
		   * @return the BinaryNode of the right child (or null if no child exists)
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
		   */
		  public BinaryNode1<E> right(BinaryNode1<E> p) throws IllegalArgumentException {
			  BinaryNode1<E> node = validate(p);
		    return node.getRight();
		  }

		  // update methods supported by this class
		  /**
		   * Places element e at the root of an empty tree and returns its new BinaryNode.
		   *
		   * @param e   the new element
		   * @return the BinaryNode of the new element
		   * @throws IllegalStateException if the tree is not empty
		   */
		  public BinaryNode1<E> addRoot(E e) throws IllegalStateException {
		    if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
		    root = new BinaryNode1<E>(e, null, null, null);
		    size = 1;
		    return root;
		  }

		  private boolean isEmpty() {
			// TODO Auto-generated method stub
			  if(root ==null) return true;
			return false;
		}
		/**
		   * Creates a new left child of BinaryNode p storing element e and returns its BinaryNode.
		   *
		   * @param p   the BinaryNode to the left of which the new element is inserted
		   * @param e   the new element
		   * @return the BinaryNode of the new element
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
		   * @throws IllegalArgumentException if p already has a left child
		   */
		  public BinaryNode1<E> addLeft(BinaryNode1<E> p, E e)
		                          throws IllegalArgumentException {
			  BinaryNode1<E> parent = validate(p);
		    if (parent.getLeft() != null)
		      throw new IllegalArgumentException("p already has a left child");
		    BinaryNode1<E> child = new BinaryNode1<E>(e, parent, null, null);
		    parent.setLeft(child);
		    size++;
		    if(parent.getRight()!=null) {size--;}
		    return child;
		  }

		  /**
		   * Creates a new right child of BinaryNode p storing element e and returns its BinaryNode.
		   *
		   * @param p   the BinaryNode to the right of which the new element is inserted
		   * @param e   the new element
		   * @return the BinaryNode of the new element
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree.
		   * @throws IllegalArgumentException if p already has a right child
		   */
		  public BinaryNode1<E> addRight(BinaryNode1<E> p, E e)
		                          throws IllegalArgumentException {
			  BinaryNode1<E> parent = validate(p);
		    if (parent.getRight() != null)
		      throw new IllegalArgumentException("p already has a right child");
		    BinaryNode1<E> child = new BinaryNode1<E>(e, parent, null, null);
		    parent.setRight(child);
		    size++;
		    if(parent.getLeft()!=null) {size--;}
		    return child;
		  }

		  /**
		   * Replaces the element at BinaryNode p with element e and returns the replaced element.
		   *
		   * @param p   the relevant BinaryNode
		   * @param e   the new element
		   * @return the replaced element
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree.
		   */
		  public E set(BinaryNode1<E> p, E e) throws IllegalArgumentException {
			  BinaryNode1<E> node = validate(p);
		    E temp = node.getElement();
		    node.setElement(e);
		    return temp;
		  }

		  /**
		   * Attaches trees t1 and t2, respectively, as the left and right subtree of the
		   * leaf BinaryNode p. As a side effect, t1 and t2 are set to empty trees.
		   *
		   * @param p   a leaf of the tree
		   * @param t1  an independent tree whose structure becomes the left child of p
		   * @param t2  an independent tree whose structure becomes the right child of p
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree
		   * @throws IllegalArgumentException if p is not a leaf
		   */
		  public void attach(BinaryNode1<E> p, myLinkedBinaryTree<E> t1,
				  myLinkedBinaryTree<E> t2) throws IllegalArgumentException {
			  BinaryNode1<E> node = validate(p);
		    if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
		    size += t1.size() + t2.size();
		    if (!t1.isEmpty()) {                  // attach t1 as left subtree of node
		      t1.root.setParent(node);
		      node.setLeft(t1.root);
		      t1.root = null;
		      t1.size = 0;
		    }
		    if (!t2.isEmpty()) {                  // attach t2 as right subtree of node
		      t2.root.setParent(node);
		      node.setRight(t2.root);
		      t2.root = null;
		      t2.size = 0;
		    }
		  }

		  private boolean isInternal(BinaryNode1<E> p) {
			  if(p.getLeft() !=null || p.getRight()!=null) 
				  return true;
			// TODO Auto-generated method stub
			return false;
		}
		/**
		   * Removes the node at BinaryNode p and replaces it with its child, if any.
		   *
		   * @param p   the relevant BinaryNode
		   * @return element that was removed
		   * @throws IllegalArgumentException if p is not a valid BinaryNode for this tree.
		   * @throws IllegalArgumentException if p has two children.
		   */
		 public E remove(BinaryNode1<E> p) throws IllegalArgumentException {
			BinaryNode1<E> node = validate(p);
		    if (numChildren(p) == 2)
		      throw new IllegalArgumentException("p has two children");
		    BinaryNode1<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight() );
		    if (child != null)
		      child.setParent(node.getParent());  // child's grandparent becomes its parent
		    if (node == root)
		      root = child;                       // child becomes root
		    else {
		    	BinaryNode1<E> parent = node.getParent();
		      if (node == parent.getLeft())
		        parent.setLeft(child);
		      else
		        parent.setRight(child);
		    }
		    size--;
		    E temp = node.getElement();
		    node.setElement(null);                // help garbage collection
		    node.setLeft(null);
		    node.setRight(null);
		    node.setParent(node);                 // our convention for defunct node
		    return temp;
		  }
		  
		public int numChildren(BinaryNode1<E> p) {
			BinaryNode1<E> node = validate(p);
			if (node.getRight()!=null) {
				rightSide++;
				this.numChildren(node.getRight());
				}
			if (node.getLeft()!=null) {
				leftSide++;
				this.numChildren(node.getLeft());
				}
			children = rightSide+leftSide;
			return children;
		}
		
		public void pruneSubtree(BinaryNode1<E> p) {
			BinaryNode1<E> node = validate(p);
			int numOfchldrn = this.numChildren(node);
			while( numOfchldrn > 0 ) {
				if(node.getLeft()!=null) {
					this.remove( node.getLeft() );
				}
				if( node.getRight()!=null ) {
					this.remove( node.getRight() );
				}
				numOfchldrn--;
			}
		}
		
		public void traverseInOrder(BinaryNode1<E> p){ // Recursion for InOrder Traversal
		    BinaryNode1<E> node = validate(p);
		    if (node.getLeft() != null){
		        traverseInOrder(node.getLeft());
		    }
		    
		    System.out.print(node.getElement()+", ");
		    if (node.getRight() != null){
		        traverseInOrder(node.getRight());
		    }
		}
		
		public Boolean findElement(BinaryNode1<E> b, E value) {
			if (b!= null) {
				if ( b.getElement() == value) {
					return true;
				} 
				else if(b.getLeft()!=null) {
					findElement(b.getLeft(),value);
				}
				else if(b.getRight()!=null) {
					findElement(b.getRight(),value);
				}
			}
			return false;
		}

}
