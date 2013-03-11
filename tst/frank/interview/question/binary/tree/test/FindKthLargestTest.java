package frank.interview.question.binary.tree.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frank.interview.binary.tree.BinaryTree;
import frank.interview.binary.tree.BinaryTree.ChildNodeType;
import frank.interview.question.binary.tree.FindKthLargest;

public class FindKthLargestTest {
	
	private BinaryTree<Integer> tree;

	@Before
	public void setUp() throws Exception {
		tree = new BinaryTree<Integer>(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFind1() {
		/*
		 *            10
		 *        5        15
		 *      2   7    11   17
		 *    1                  18
		 */
		tree.insertNodeAt(tree.getRoot(), 5, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), 15, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), 2, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), 7, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), 11, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), 17, ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft().getLeft(), 1, ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight().getRight(), 18, ChildNodeType.RIGHT_CHILD);
		
		assertEquals(18, (int)(new FindKthLargest<Integer>().find(tree, 1)));
		assertEquals(17, (int)(new FindKthLargest<Integer>().find(tree, 2)));
		assertEquals(15, (int)(new FindKthLargest<Integer>().find(tree, 3)));
		assertEquals(11, (int)(new FindKthLargest<Integer>().find(tree, 4)));
		assertEquals(10, (int)(new FindKthLargest<Integer>().find(tree, 5)));
		assertEquals(7, (int)(new FindKthLargest<Integer>().find(tree, 6)));
		assertEquals(5, (int)(new FindKthLargest<Integer>().find(tree, 7)));
		assertEquals(2, (int)(new FindKthLargest<Integer>().find(tree, 8)));
		assertEquals(1, (int)(new FindKthLargest<Integer>().find(tree, 9)));
	}

}
