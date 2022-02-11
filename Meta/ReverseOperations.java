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

  // first try, didn't go anywhere
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

  // Online LC high vote solution
  Node reverseOdds(Node head) {
    Node prev = null;
    Node curr = head;

    while (curr != null && curr.data % 2 == 0) {
      Node t = curr.next;
      curr.next = prev;
      prev = curr;
      curr = t;
    }

    head.next = curr;

    return prev;
  }

  // solution:
  // https://leetcode.com/discuss/interview-question/688086/FB-Online-Practice-Question/855972

  Node reverse2(Node head) {
    // Write your code here
    Node dummy = new Node(0);
    dummy.next = head;

    Node prev = dummy;
    Node curr = head;

    while (curr != null) {
      if (curr.data % 2 == 0) {
        prev.next = reverseOdds(curr);
      }

      prev = curr;
      curr = curr.next;
    }

    return dummy.next;
  }

  // O(n) java stack solution -- seems easier to understand
  // https://leetcode.com/discuss/interview-question/688086/FB-Online-Practice-Question/1244249
  Node reverse3(Node head) {
    Node newHead = new Node(0);
    Node newCurr = newHead;
    Node curr = head;

    while (curr != null) {
      // a new subpart has been reached
      if (curr.data % 2 == 0) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(curr.data);

        // push each subpart element to the stack
        while (curr.next != null && curr.next.data % 2 == 0) {
          stack.push(curr.next.data);
          curr = curr.next;
        }

        // pop each subpart element from stack and add to resulting list
        while (!stack.isEmpty()) {
          newCurr.next = new Node(stack.pop());
          newCurr = newCurr.next;
        }

        // set curr to the next non-subpart element
        curr = curr.next;

      } else {
        newCurr.next = new Node(curr.data);
        newCurr = newCurr.next;
        curr = curr.next;
      }
    }

    return newHead.next;
  }
}
