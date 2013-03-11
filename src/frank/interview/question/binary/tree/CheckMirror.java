package frank.interview.question.binary.tree;

import frank.interview.binary.tree.BinaryTree;
import frank.interview.binary.tree.Node;

public class CheckMirror {

	public static <T> boolean checkMirror(BinaryTree<T> tree) {
		if (tree == null) {
			return false;
		}
		return doCheckTwoTreesMirror(tree.getRoot().getLeft(), tree.getRoot().getRight());
	}
	
	private static <T> boolean doCheckTwoTreesMirror(Node<T> rootA, Node<T> rootB) {
		if ((rootA == null && rootB != null)
			|| (rootA != null && rootB == null)) {
			return false;
		}
		if (rootA == null && rootB == null) {
			return true;
		}
		return (rootA.getValue() == rootB.getValue()) 
			&& doCheckTwoTreesMirror(rootA.getLeft(), rootB.getRight())
			&& doCheckTwoTreesMirror(rootA.getRight(), rootB.getLeft());
	}
}
