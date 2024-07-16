package twoPointers;

public class RemoveNthNodeFromEnd {
	
	/*
	 * Given the head of a linked list, remove the nth node 
	 * from the end of the list and return its head.

		Example 1:
		
		Input: head = [1,2,3,4,5], n = 2
		Output: [1,2,3,5]
		
		Example 2:
		
		Input: head = [1], n = 1
		Output: []
		
		Example 3:
		
		Input: head = [1,2], n = 1
		Output: [1]
		 
		
		Constraints:
		
		The number of nodes in the list is sz.
		1 <= sz <= 30
		0 <= Node.val <= 100
		1 <= n <= sz
	 */
	
	public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        if (head == null) return head;
        
        LinkedListNode first = head;
        LinkedListNode second= head;
        
        // move n + 1 steps forward
        int i = 0;
        while (first != null && i < n + 1) {
            first = first.next;
            i++;
        }

        // remove 1st node from linked list
        if (first == null && i != n + 1) return head.next;

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // second is pointing to target node’s previous node
        second.next = second.next.next;
        
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
