package frank.interview.question.binary.tree.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frank.interview.binary.tree.BinaryTree;
import frank.interview.binary.tree.BinaryTree.ChildNodeType;
import frank.interview.binary.tree.Node;
import frank.interview.question.binary.tree.FindLargestBST;

public class FindLargestBstTest {

	private BinaryTree<Integer> tree;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind1() {
		/*
		 *          7
		 *       5     8
		 */
		tree = new BinaryTree<Integer>(7);
		tree.insertNodeAt(tree.getRoot(), 5, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), 8, ChildNodeType.RIGHT_CHILD);
		
		Node<Integer> node = FindLargestBST.find(tree);
		assertEquals(tree.getRoot(), node);
	}
	
	@Test
	public void testFind2() {
		/*
		 *            7
		 *       5         8
		 *     1   3     6   9
		 */
		tree = new BinaryTree<Integer>(7);
		tree.insertNodeAt(tree.getRoot(), 5, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), 8, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), 1, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), 3, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), 6, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), 9, ChildNodeType.RIGHT_CHILD);
		
		Node<Integer> node = FindLargestBST.find(tree);
		assertEquals(tree.getRoot().getRight(), node);
	}

	@Test
	public void testFind3() {
		/*
		 *            7
		 *       3         9
		 *     1   5     8   10
		 */
		tree = new BinaryTree<Integer>(7);
		tree.insertNodeAt(tree.getRoot(), 3, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), 9, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), 1, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), 5, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), 8, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), 10, ChildNodeType.RIGHT_CHILD);
		
		Node<Integer> node = FindLargestBST.find(tree);
		assertEquals(tree.getRoot(), node);
	}
	
	@Test
	public void testFind4() {
		/*
		 *            7
		 *       3         9
		 *     1   5     6   10
		 *        4
		 */
		tree = new BinaryTree<Integer>(7);
		tree.insertNodeAt(tree.getRoot(), 3, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), 9, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), 1, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), 5, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), 6, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), 10, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft().getRight(), 4, ChildNodeType.LEFT_CHILD);
		
		Node<Integer> node = FindLargestBST.find(tree);
		assertEquals(tree.getRoot().getLeft(), node);
	}
	
}
