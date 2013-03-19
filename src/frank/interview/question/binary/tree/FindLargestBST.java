package frank.interview.question.binary.tree;

import frank.interview.binary.tree.BinaryTree;
import frank.interview.binary.tree.Node;

/*
 * Find the largest binary search tree from a binary tree. Largest in terms of 
 * number of elements in the sub-tree
 */
public class FindLargestBST {

	public static Node<Integer> find(BinaryTree<Integer> tree) {
		Result result = doFind(tree.getRoot());
		return result.bstRoot;
	}
	
	static class Result {
		Node<Integer> root;
		int maxValue = 0;
		int minValue = 0;
		boolean isBst = false;
		// largest BST in the sub-tree of root node
		Node<Integer> bstRoot;
		int numNode = 0;
		
		public Result(Node<Integer> root) {
			this.root = root;
		}
	}
	
	private static Result doFind(Node<Integer> root) {
		Result res = new Result(root);
		if (root == null) {
			res.isBst = true;
			res.numNode = 0;
			return res;
		}
		Result left = doFind(root.getLeft());
		Result right = doFind(root.getRight());
		if (left.isBst && right.isBst 
				&& (left.numNode == 0 || root.getValue() >= left.maxValue)
				&& (right.numNode == 0 || root.getValue() <= right.minValue)) {
			res.isBst = true;
			res.numNode = left.numNode + right.numNode + 1;
			if (right.numNode > 0) {
				res.maxValue = right.maxValue;
			} else {
				res.maxValue = root.getValue();
			}
			
			if (left.numNode > 0) {
				res.minValue = left.minValue;
			} else {
				res.minValue = root.getValue();
			}
			
			res.bstRoot = root;
		} else {
			res.isBst = false;
			if (left.numNode >= right.numNode) {
				res.bstRoot = left.bstRoot;
				res.numNode = left.numNode;
			} else {
				res.bstRoot = right.bstRoot;
				res.numNode = right.numNode;
			}
		}
		return res;
	}
	
}
