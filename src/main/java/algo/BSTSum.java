package main.java.algo;

import java.util.Stack;

/*
 * find a pair values add together as sum. O(n) time comlicity and O(logn space), 
 * no modify to tree.
 * 
 * */

public class BSTSum {
	public BSTSum(){}
	
	public boolean isSum(TreeNode root, int sum){
		if(root == null)
			return false;
		
		Stack<TreeNode> inOrder = new Stack<TreeNode>();
		Stack<TreeNode> traOrder = new Stack<TreeNode>();

		TreeNode l = root;
		TreeNode r = root;
		while(l != null || r != null){
			if(l != null){
				inOrder.push(l);
				l = l.left;
			}
			if(r != null){
				traOrder.push(r);
				r = r.right;
			}
		}
		
		l = inOrder.pop();
		r = traOrder.pop();
		
		while(l != r){
			if(l.val + r.val == sum){
				System.out.println(l.val + " + " + r.val + " = " + sum);
				return true;
			}else if(l.val + r.val > sum){
				r = traOrder.pop();
				if(r.left != null){
					TreeNode n = r.left;
					while(n != null){
						traOrder.push(n);
						n = n.right;
					}
				}
			}else{
				l = inOrder.pop();
				TreeNode n = l.right;
				while(n != null){
					inOrder.push(n);
					n = n.left;
				}
			}
		}
		
		return false;
	}
	
	
	
	public static void main(String args[]){
		BSTSum test = new BSTSum();
		TreeNode root =  new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(12);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);
		
		System.out.println(test.isSum(root, 33));
	}
}
