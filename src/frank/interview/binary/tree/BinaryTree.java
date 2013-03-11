package frank.interview.binary.tree;

public class BinaryTree<T> {

	public enum ChildNodeType {
		LEFT_CHILD, 
		RIGHT_CHILD
	}; 
	
	Node<T> root = null;
	public BinaryTree(T value) {
		root = new Node<T>(value);
	}
	
	public Node<T> getRoot() {
		return root;
	}
	
	public boolean insertNodeAt(Node<T> node, T value, ChildNodeType type) {
		if (node == null) {
			return false;
		}
		if (type == ChildNodeType.LEFT_CHILD) {
			Node<T> leftChild = new Node<T>(value);
			node.setLeft(leftChild);
		} else {
			Node<T> rightChild = new Node<T>(value);
			node.setRight(rightChild);
		}
		return true;
	}
}
