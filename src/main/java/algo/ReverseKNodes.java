package main.java.algo;

public class ReverseKNodes {

	public ReverseKNodes() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Node reverseNodes(Node head, int k){		
		return reverseNodesHelper(head, k, true);
	}
	
	public Node reverse(Node head){
		if(head.next == null)
			return head;
		Node newHead = reverse(head.next);
		Node n = newHead;
		while(n.next != null){
			n = n.next;
		}
		n.next = head;
		head.next = null;		
		return newHead;
		
	}
	
	public Node reverseNodesHelper(Node head, int k, boolean flip){
		if(head.next == null){
			return head;
		}
		
		if(k == 1)
			return head;
						
		if(flip){			
				Node newHead = reverseNodesHelper(head.next, k - 1, true);
				Node n = newHead;
				int i = k - 1;
				while(i > 1 && n.next != null){
					n = n.next;
					i --;
				}
				if(n.next != null)
					head.next = reverseNodesHelper(n.next, k, false);
				else
					head.next = null;
				n.next = head;
				return newHead;	
			
		}else{
			int i = k;
			Node newHead = head;
			while(i > 1 && newHead.next != null){
				newHead = newHead.next;
				i --;
			}
			
			if(newHead.next != null){
				newHead.next = reverseNodesHelper(newHead.next, k, true);
			}
			
			return head;
		}
	}

	public static void main(String args[]){
		ReverseKNodes test = new ReverseKNodes();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		Node n = test.reverseNodes(head, 1);
		while(n != null){
			System.out.println(n.value);
			n = n.next;
		}
	}
}
