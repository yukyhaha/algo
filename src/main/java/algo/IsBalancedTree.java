package main.java.algo;
/*
 * check if a tree is balanced.
 * 
 * */

public class IsBalancedTree {

	public IsBalancedTree() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isBalanced(TreeNode root){
		if(height(root) == -1){
			return false;
		}else{
			return true;
		}
	}
	
	public int height(TreeNode root){
		if(root == null)
			return 0;
			
		int lh = height(root.left);
		
		if(lh == -1)
			return -1;
		
		int rh = height(root.right);		
		if(rh == -1)
			return -1;
		
		if(Math.abs(lh - rh) > 1){
			return -1;
		}else{
			return Math.max(lh, rh) + 1;
		}
				
	}
	
	public static void main(String args[]){
		  IsBalancedTree test = new IsBalancedTree();
		  TreeNode root =new TreeNode(1);  
		  root.left = new TreeNode(2);
		  root.right = new TreeNode(3);
		  root.left.left = new TreeNode(4);
		  root.left.right = new TreeNode(5);
		  //root.right.left = new TreeNode(6);
		  root.left.left.left = new TreeNode(7);
		  System.out.println(test.isBalanced(root));
		
	}

	
	
}
