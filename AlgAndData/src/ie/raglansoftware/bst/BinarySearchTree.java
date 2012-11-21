package ie.raglansoftware.bst;

import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree {
	private BSTNode root;
	
	public void insert(int key) {
		BSTNode newNode = new BSTNode(key);
		if(root==null) {
			root = newNode;
		}
		else {
			root.insert(newNode);
		}
	}
	
	public BSTNode searchFirst(int key) {
		if (root==null) {
			return null;
		}
		return root.searchFirst(key);
	}
	
	public List<BSTNode> InOrderWalk() {
		if (root == null) {
			return null;
		}
		return root.inOrderWalk(new ArrayList<BSTNode>());
	}
	
	public void transplant(BSTNode target, BSTNode source) {
		
	}
}
