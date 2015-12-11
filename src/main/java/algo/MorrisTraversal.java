package main.java.algo;

/*morrisTraversal: traverse the tree using O(1) space and 
 * no need to modify the tree structure*/

public class MorrisTraversal {

	public MorrisTraversal() {
		// TODO Auto-generated constructor stub
	}
	/*there are two nodes are swapped in the binary tree, recover it with O(1)
	 * space and not modification to the tree structure;
	 * */
	public void recoverBinaryTree(TreeNode root){
		TreeNode currNode = root;
		TreeNode firstNode = null;
		TreeNode secondNode = null;
		TreeNode lastNode = null;
		while(currNode != null){
			if(currNode.left != null){	
				TreeNode preNode = currNode.left;
				while(preNode.right != null && preNode.right != currNode){
					preNode = preNode.right;
				}
				
				if(preNode.right == null){
					preNode.right = currNode;
					currNode = currNode.left;
				}else if(preNode.right == currNode){
					//System.out.println(currNode.val);
					if(lastNode != null){
						if(firstNode == null){
							if(currNode.val < lastNode.val){
								firstNode = lastNode;
								secondNode = currNode;
							}
						}
						
						if(secondNode != null && currNode.val < secondNode.val){
							secondNode = currNode;
						}
					
					}
					
					lastNode = currNode;
					preNode.right = null;
					currNode = currNode.right;
				}
			}else{
				//System.out.println(currNode.val);
				if(lastNode != null){
					if(firstNode == null){
						if(currNode.val < lastNode.val){
							firstNode = lastNode;
							secondNode = currNode;
						}
					}
					
					if(secondNode != null && currNode.val < secondNode.val){
						secondNode = currNode;
					}
				
				}
				lastNode = currNode;
				currNode = currNode.right;				
			}
		}
		
		int tmp = firstNode.val;
		firstNode.val = secondNode.val;
		secondNode.val = tmp;
		printTree(root);
	}
	
	public void printTree(TreeNode root){
		if(root == null)
			return;
		printTree(root.left);
		System.out.println(root.val);
		printTree(root.right);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MorrisTraversal t = new MorrisTraversal();
		TreeNode root =  new TreeNode(15);
		root.left = new TreeNode(10);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(20);
		root.right.left = new TreeNode(16);
		root.right.right = new TreeNode(25);
		t.recoverBinaryTree(root);

	}

}
