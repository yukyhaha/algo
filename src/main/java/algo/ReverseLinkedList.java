package main.java.algo;

public class ReverseLinkedList {

	public ReverseLinkedList() {
		// TODO Auto-generated constructor stub
	}
	
    public Node reverseBetween(Node head, int m, int n) {
        if(m == n)
            return head;
            
        Node t1, h1;
        if(m == 1){
            t1 = null;
            h1 = head;
        }else{
            t1 = head;
            for(int i = 0; i < m - 2; i ++){
                t1 = t1.next;
            }
            h1 = t1.next;
        }
        
        Node h2 = h1;
        Node t2 = h2.next;
        Node p3 = t2.next;
        int count = n - m;
        while(t2 != null && count > 0){
            t2.next = h2;
            h2 = t2;
            t2 = p3;
            if(p3 != null)
                p3 = p3.next;
            count --;
        }

        h1.next = t2;
        if(t1 != null)
            t1.next = h2;
        else
            head = h2;
        
        return head;
    }

	public static void main(String args[]){
		ReverseLinkedList t = new ReverseLinkedList();
		Node head = new Node(3);
		head.next = new Node(5);
		t.reverseBetween(head, 1, 2);
		while(head != null){
			System.out.println(head.value);
			head = head.next;
		}
	}
}
