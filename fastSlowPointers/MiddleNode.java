package fastSlowPointers;

import GenericClasses.LinkedListNode;

public class MiddleNode {
	/*
	 * Given the head of a singly linked list, return the middle 
	 * node of the linked list. If the number of nodes in the 
	 * linked list is even, there will be two middle nodes, 
	 * so return the second one.
	 */
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public static LinkedListNode middleNode(LinkedListNode head) {
      if (head == null) return head;
  
    	LinkedListNode fast = head, slow = head;
    	while (fast != null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    
    	return slow;
    }
}
