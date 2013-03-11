package frank.interview.question.binary.tree.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frank.interview.binary.tree.BinaryTree;
import frank.interview.binary.tree.BinaryTree.ChildNodeType;
import frank.interview.question.binary.tree.CheckMirror;

public class CheckMirrorTest {

	private BinaryTree<String> tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new BinaryTree<String>("A");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckMirror1() {
		assertTrue(CheckMirror.checkMirror(tree));
	}

	@Test
	public void testCheckMirror2() {
		assertFalse(CheckMirror.checkMirror(null));
	}
	
	@Test
	public void testCheckMirror3() {
		tree.insertNodeAt(tree.getRoot(), "B", ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), "B", ChildNodeType.RIGHT_CHILD);
		assertTrue(CheckMirror.checkMirror(tree));
	}
	
	@Test
	public void testCheckMirror4() {
		tree.insertNodeAt(tree.getRoot(), "B", ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), "C", ChildNodeType.RIGHT_CHILD);
		assertFalse(CheckMirror.checkMirror(tree));
	}
	
	@Test
	public void testCheckMirror5() {
		tree.insertNodeAt(tree.getRoot(), "B", ChildNodeType.LEFT_CHILD);
		assertFalse(CheckMirror.checkMirror(tree));
	}
	
	@Test
	public void testCheckMirror6() {
		tree.insertNodeAt(tree.getRoot(), "B", ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), "B", ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), "C", ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), "C", ChildNodeType.RIGHT_CHILD);
		assertTrue(CheckMirror.checkMirror(tree));
	}
	
	@Test
	public void testCheckMirror7() {
		tree.insertNodeAt(tree.getRoot(), "B", ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot(), "B", ChildNodeType.RIGHT_CHILD);
		tree.insertNodeAt(tree.getRoot().getLeft(), "C", ChildNodeType.LEFT_CHILD);
		tree.insertNodeAt(tree.getRoot().getRight(), "C", ChildNodeType.LEFT_CHILD);
		assertFalse(CheckMirror.checkMirror(tree));
	}
	
}
