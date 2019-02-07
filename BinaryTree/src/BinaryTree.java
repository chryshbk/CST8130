package lab7;

public class BinaryTree {
	private BinaryTreeNode root = null;
	
	public void insertInTree(int newData) {
		if (root == null)
			root = new BinaryTreeNode(newData);
		else root.insert(newData);
	}
	
	public void displayInOrder() {
		displayInOrder(root);
	}
	
	public void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null) return;
		displayInOrder(subRoot.getLeft());
		System.out.print(" "+ subRoot.getData() + " ");
		displayInOrder(subRoot.getRight());
	}
	
	public void displayPreOrder() {
		displayPreOrder(root);
	}
	
	public void displayPreOrder(BinaryTreeNode subRoot) {
		if (subRoot == null) return;
		System.out.print(" "+ subRoot.getData() + " " );
		displayPreOrder(subRoot.getLeft());
		displayPreOrder(subRoot.getRight());
	}
	
	public void displayPostOrder() {
		displayPostOrder(root);
	}
	public void displayPostOrder(BinaryTreeNode subRoot) {
		if (subRoot == null) return;
		displayPostOrder(subRoot.getLeft());
		displayPostOrder(subRoot.getRight());
		System.out.print(" "+ subRoot.getData() + " ");
	}
	
	public int getHeight() {
		return getHeight(root);
	}
	
	public int getHeight(BinaryTreeNode subRoot) {
		if (subRoot == null) return 0;
		
		int leftHeight = 0;
		int rightHeight = 0;
		
		if (subRoot.getLeft() != null)
		leftHeight = 1 + getHeight(subRoot.getLeft());
		
		if (subRoot.getRight() != null)
		rightHeight = 1 + getHeight(subRoot.getRight());
		
		return leftHeight > rightHeight ? leftHeight + 1: rightHeight +1;
	}
}
