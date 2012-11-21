package ie.raglansoftware.bst;

import java.util.List;

public class BSTNode {
	
	private int 	key;
	
	private BSTNode left;
	private BSTNode right;
	private BSTNode parent;
		
	public BSTNode(int key) {
		this.key = key;
	}
	
	public void setParent(BSTNode node) {
		this.parent = node;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public void insert(BSTNode node) {
		if(this.equals(node) || node==null) {
			return;
		}
		if (isInLeftSubtree(node.getKey())) {
			placeLeft(node);
		}
		else {
			placeRight(node);
		}
	}
	
	public BSTNode searchFirst(int key) {
		if(key==this.key) {
			return this;
		}
		if (isInLeftSubtree(key) && left!=null) {
			return left.searchFirst(key);
		}
		else if (!isInLeftSubtree(key) && right!=null) {
			return right.searchFirst(key);
		}
		return null;
	}
	
	
	public List<BSTNode> inOrderWalk(List<BSTNode> sortedNodes) {
		if(left!=null) {
			left.inOrderWalk(sortedNodes);
		}
		sortedNodes.add(this);
		if (right!=null) {
			right.inOrderWalk(sortedNodes);
		}
		return sortedNodes;
	}

	public void placeLeft(BSTNode node) {
		if(left==null) {
			left = node;
			left.setParent(this);
		}
		else {
			left.insert(node);
		}
	}
	
	public void placeRight(BSTNode node) {
		if(right==null) {
			right = node;
			right.setParent(this);
		}
		else {
			right.insert(node);
		}
	}

	public boolean isInLeftSubtree(int otherKey) {
		return (key>=otherKey);
	}
}
