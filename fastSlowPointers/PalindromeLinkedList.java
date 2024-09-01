package fastSlowPointers;

import GenericClasses.LinkedListNode;
import GenericClasses.LinkedListReversal;

public class PalindromeLinkedList {
	
	/*
	 * Given the head of a linked list, your task is to check whether the linked list 
	 * is a palindrome or not. Return TRUE if the linked list is a 
	 * palindrome; otherwise, return FALSE.

		Note: The input linked list prior to the checking process should be 
		identical to the list after the checking process has been completed.
	 */
	// Time complexity -> O(n), Space complexity -> O(1)
	public static boolean palindrome(LinkedListNode head) {
      if (head == null || head.next == null) return true;
      
      LinkedListNode fast = head, slow = head;
      while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      
      LinkedListNode secondHead = slow.next;
      slow.next = null;
      
      secondHead = LinkedListReversal.reverseLinkedList(secondHead);
      
      boolean isPalindrome = true;
      LinkedListNode firstLLTemp = head, secondLLTemp = secondHead;
      while (firstLLTemp != null && secondLLTemp != null) {
        if (firstLLTemp.data != secondLLTemp.data) {
          isPalindrome = false;
          break;
        }
        
        firstLLTemp = firstLLTemp.next;
        secondLLTemp = secondLLTemp.next;
      }
      
      slow.next = LinkedListReversal.reverseLinkedList(secondLLTemp);
      return isPalindrome;
    }
}
