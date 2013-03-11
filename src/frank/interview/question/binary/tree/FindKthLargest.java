package frank.interview.question.binary.tree;

import frank.interview.binary.tree.BinaryTree;
import frank.interview.binary.tree.Node;

/**
 * Find k-th largest element from a BST
 * @author Frank
 * @param <T>
 *
 */
public class FindKthLargest<T> {

	int current = 0;
	T result = null;
	
	public T find(BinaryTree<T> tree, int k) {
		if (tree == null)
			return null;
		doFind(tree.getRoot(), k);
		return result;
	}
	
	private void doFind(Node<T> node, int k) {
		if (node == null) {
			return;
		}
		doFind(node.getRight(), k);
//		System.out.print(node.getValue()+"  ");
		current++;
		if (current == k) {
			result = node.getValue();
		}
		doFind(node.getLeft(), k);
	}
	
	
}
