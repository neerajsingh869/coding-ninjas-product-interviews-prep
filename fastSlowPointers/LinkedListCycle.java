package fastSlowPointers;

import java.util.HashSet;
import java.util.Set;

import GenericClasses.LinkedList;
import GenericClasses.LinkedListNode;
import GenericClasses.PrintList;

public class LinkedListCycle {
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
