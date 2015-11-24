package main.java.geeksforgeeks;

public class BSTSum {
	public BSTSum(){}
	
	public boolean isSum(TreeNode root, int sum){

		TreeNode n1 = root;
		TreeNode n2 = root;
	
		while(n1 != null && n2 != null){	
			if(n1.val + n2.val > sum / 2){
				n1 = root.left;
			}else{
				n2 = root.right;
			}
		}
		
	}
	
	
	
	public static void main(String args[]){
		
	}
}
