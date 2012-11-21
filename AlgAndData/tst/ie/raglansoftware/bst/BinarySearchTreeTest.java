package ie.raglansoftware.bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeTest {
	
	private int[] testGoodInputKeys;
	private BinarySearchTree tree;
	
	@Before public void setUp() {
		testGoodInputKeys = new int[] {3,5,6,7,2,3,-1,2};
		tree = new BinarySearchTree();
		for(int key : testGoodInputKeys)
		{
			tree.insert(key);
		}
	}
	
	@Test public void inOrderWalk_givenInput_returnsSortedWalk() 
	{
		List<BSTNode> inOrderNodes = tree.InOrderWalk();
		
		int[] walkedKeys = new int[inOrderNodes.size()];
		for(int i = 0; i < inOrderNodes.size(); i++) {
			walkedKeys[i]=inOrderNodes.get(i).getKey();
		}
		Arrays.sort(testGoodInputKeys);
		assertTrue(Arrays.equals(testGoodInputKeys, walkedKeys));
	}
	
	@Test public void searchFirst_givenInputWithDuplicates_findsFirstThree() {
		
	}
	
	@Test public void searchFirst_givenInputWithDuplicates_returnsNullIfNothingFound() {
		BSTNode result = tree.searchFirst(999);
		
		assertNull(result);
	}
	
	@Test public void searchFirst_givenInputWithDuplicates_returnsThree() {
		BSTNode result = tree.searchFirst(3);
		
		assertEquals(3, result.getKey());
	}
}
