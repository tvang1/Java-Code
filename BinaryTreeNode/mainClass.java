package BinaryTreeNode;

public class mainClass {

	public static void main(String[] args) {
		
		myLinkedBinaryTree <Integer> treeA = new myLinkedBinaryTree <Integer>();
		myLinkedBinaryTree <Integer> treeB = new myLinkedBinaryTree <Integer>();
		myLinkedBinaryTree <Integer> treeC = new myLinkedBinaryTree <Integer>();
		
		treeA.addRoot(1);
		treeA.addLeft(treeA.root, 2);
		treeA.addRight(treeA.root, 19);
		treeA.addLeft( treeA.root.getLeft(), 3);
		treeA.addLeft( treeA.root.getLeft().getLeft(), 4);
		treeA.addLeft( treeA.root.getLeft().getLeft().getLeft(), 5);
		
		System.out.println( "The size of Tree A is: "+treeA.size() );

		treeA.pruneSubtree( treeA.root.getLeft() );
		System.out.println( "The size of Tree A after pruning is: "+treeA.size()+"\n" );
		
		treeB.addRoot(14);
		treeB.addRight(treeB.root, 17);
		treeB.addLeft(treeB.root, 4);
		
		System.out.println( "The size of Tree B is: "+treeB.size()+"\n" );
		
		treeC.addRoot(100);
		treeC.attach(treeC.root, treeA, treeB);
		
		System.out.println( "The size of Tree C is after attaching Tree A and Tree B is: "+treeC.size()+"\n" );
		
		System.out.print("InOrder: ");
		treeC.traverseInOrder(treeC.root);
		System.out.println( "\n"+treeC.findElement(treeC.root,100) );
		
		System.out.println( treeC.parent( treeC.root.getLeft() ).getElement() );
		
	}

	
}
