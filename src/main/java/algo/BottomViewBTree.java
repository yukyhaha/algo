package main.java.algo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BottomViewBTree {

	public BottomViewBTree() {
		// TODO Auto-generated constructor stub
	}

	public void bottomView(TreeNode root){
		Hashtable<TreeNode, Integer> treeTable = new Hashtable<TreeNode, Integer>(); 
		Hashtable<Integer, TreeNode> disTable = new Hashtable<Integer, TreeNode>(); 
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();		
		q.add(root);
		treeTable.put(root, 0);
		disTable.put(0, root);
		int minDis = 0;
		
		while(!q.isEmpty()){
			TreeNode n = q.poll();
			int dis = treeTable.get(n);
			minDis = Math.min(minDis, dis);
			if(n.left != null){
				q.add(n.left);
				treeTable.put(n.left, dis - 1);
				disTable.put(dis - 1, n.left);
			}
			
			if(n.right != null){
				q.add(n.right);
				treeTable.put(n.right, dis + 1);
				disTable.put(dis + 1, n.right);
			}
			
		}
		
		
		while(disTable.containsKey(minDis)){
			System.out.println(disTable.get(minDis).val);
			minDis ++;
		}
		
		
	}

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  TreeNode root = new TreeNode(20);
	        root.left = new TreeNode(8);
	        root.right = new TreeNode(22);
	        root.left.left = new TreeNode(5);
	        root.left.right = new TreeNode(3);
	        root.right.left = new TreeNode(4);
	        root.right.right = new TreeNode(25);
	        root.left.right.left = new TreeNode(10);
	        root.left.right.right = new TreeNode(14);
		
		BottomViewBTree test = new BottomViewBTree();
		test.bottomView(root);

	}

}
