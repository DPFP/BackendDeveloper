public class ReverseOperations {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // Add any helper functions you may need here

    Node reverse(Node head) {
        // Write your code here
        
        //teamp 
        Node cur = head; 
        
        Node subPart = new Node(-1);
        while(head != null){
          if(head.data % 2 = 1){
            cur.next = subPart; 
            subPart.next = null; 
          }else{
            subPart.next = head; 
          }
          
          head = head.next; 
        }
        
      }
}
