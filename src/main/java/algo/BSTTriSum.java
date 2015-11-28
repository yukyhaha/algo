package main.java.algo;

/*
 * http://www.geeksforgeeks.org/find-if-there-is-a-triplet-in-bst-that-adds-to-0/
 * Given a Balanced Binary Search Tree (BST), write a function isTripletPresent() that 
 * returns true if there is a triplet in given BST with sum equals to 0, otherwise returns false. 
 * Expected time complexity is O(n^2) and only O(Logn) extra space can be used. 
 * You can modify given Binary Search Tree. Note that height of a Balanced BST is always O(Logn)
 * 
 * */


public class BSTTriSum {

	public BSTTriSum() {
		// TODO Auto-generated constructor stub
	}
	
	public void convertBstToDll(TreeNode root, TreeNode head, TreeNode tail){
		convertBstToDll(root.left, head, tail);
		
		root.left = tail;		
		if(tail != null){
			tail.right = root;
		}else{
			head = root;
		}
		tail = root;
		
		convertBstToDll(root.right, head, tail);
	
	}
	
	public boolean isTriSum(TreeNode root, int sum){
		TreeNode head = null, tail = null;
		convertBstToDll(root, head, tail);
		
		TreeNode n1 = head;
		
		while(n1 != null){
			int twoSum = sum - n1.val;
			TreeNode n2 = n1.right;
			TreeNode n3 = tail;
			while(n2 != n3){
				if(n2.val + n3.val == twoSum){
					return true;
				}
				else if(n2.val + n3.val > twoSum){
					n3 = n3.left;
				}else{
					n2 = n2.right;
				}
			}
			n1 = n1.right;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BSTTriSum test = new BSTTriSum();

	}

}
