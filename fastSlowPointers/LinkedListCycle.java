package fastSlowPointers;

import java.util.HashSet;
import java.util.Set;

import GenericClasses.LinkedList;
import GenericClasses.LinkedListNode;
import GenericClasses.PrintList;

public class LinkedListCycle {
	/*
	 * Given head, the head of a linked list, determine if the 
	 * linked list has a cycle in it.

		There is a cycle in a linked list if there is some node in 
		the list that can be reached again by continuously following 
		the next pointer. Internally, pos is used to denote the index 
		of the node that tail's next pointer is connected to. Note that 
		pos is not passed as a parameter.
		
		Return true if there is a cycle in the linked list. Otherwise, 
		return false.
	 */
	
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static boolean detectCycle1(LinkedListNode head) {
	    Set<LinkedListNode> visited = new HashSet<>();
	    LinkedListNode curr = head;

	    while (curr != null) {
	      if (visited.contains(curr)) return true;

	      visited.add(curr);
	      curr = curr.next;

	    }  

	    return false;
	  }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public static boolean detectCycle2(LinkedListNode head) {
	    LinkedListNode slow = head;
	    LinkedListNode fast = head;

	    while (fast != null && fast.next != null) {
	      fast = fast.next.next;
	      slow = slow.next;

	      if (fast == slow) return true;
	    } 

	    return false;
	  }
	
	/*
	 * Given the head of a linked list, return the node where 
	 * the cycle begins. If there is no cycle, return null.

		There is a cycle in a linked list if there is some node in the 
		list that can be reached again by continuously following the 
		next pointer. Internally, pos is used to denote the index of 
		the node that tail's next pointer is connected to (0-indexed). 
		It is -1 if there is no cycle. Note that pos is not passed as 
		a parameter.
		
		Do not modify the linked list.
		
		Example 1:
		Input: head = [3,2,0,-4], pos = 1
		Output: tail connects to node index 1
		Explanation: There is a cycle in the linked list, 
		where tail connects to the second node.
		
		Example 2:
		Input: head = [1,2], pos = 0
		Output: tail connects to node index 0
		Explanation: There is a cycle in the linked list, 
		where tail connects to the first node.
	 */
	// Time complexity -> O(n), Space complexity -> O(n)
	public LinkedListNode detectCycle3(LinkedListNode head) {
	    Set<LinkedListNode> nodeSet = new HashSet<>();

	    LinkedListNode curr = head;
	    while (curr != null) {
	        if (nodeSet.contains(curr)) return curr;
	        
	        nodeSet.add(curr);
	        curr = curr.next;
	    }

	    return null;
	}
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public LinkedListNode detectCycle4(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) break;
        }

        if (fast != null && fast.next != null) {
            slow = head;

            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }

            return fast;
        }
        
        return null;
    }
	
    public static void main(String args[]) {
        int[][] input = { { 2, 4, 6, 8, 10, 12 }, { 1, 3, 5, 7, 9, 11 },
                { 0, 1, 2, 3, 4, 6 }, { 3, 4, 7, 9, 11, 17 }, { 5, 1, 4, 9, 2, 3 } };
        int[] pos = { 0, -1, 1, -1, 2 };
        for (int i = 0; i < input.length; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(i + 1 + ".\tInput:");
            System.out.print("\t");
            if (pos[i] == -1) {
                PrintList.printListWithForwardArrow(list.head);
            } else {
                PrintList.printListWithForwardArrowLoop(list.head);
            }
            System.out.println("\n\tpos: " + pos[i]);

            if (pos[i] != -1) {
                int length = list.getLength(list.head);
                LinkedListNode lastNode = list.getNode(list.head, length - 1);
                lastNode.next = list.getNode(list.head, pos[i]);
            }
            System.out.println("\n\tDetected Cycle =  " + detectCycle2(list.head));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
