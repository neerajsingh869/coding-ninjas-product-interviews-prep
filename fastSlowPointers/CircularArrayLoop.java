package fastSlowPointers;

import java.util.HashMap;
import java.util.Map;

public class CircularArrayLoop {
	
	/*
	 * We are given a circular array of non-zero integers, 
	 * nums, where each integer represents the number of 
	 * steps to be taken either forward or backward from 
	 * its current index. Positive values indicate forward 
	 * movement, while negative values imply backward movement. 
	 * When reaching either end of the array, the traversal 
	 * wraps around to the opposite end.

		The input array may contain a cycle, which is a sequence of 
		indexes characterized by the following:
		
		The sequence starts and ends at the same index.
		The length of the sequence is at least two.
		The loop must be in a single direction, forward or backward.
		Note: A cycle in the array does not have to originate at the 
		beginning. It may begin from any point in the array.
		
		Your task is to determine if nums has a cycle. Return TRUE 
		if there is a cycle. Otherwise return FALSE.
	 */
	
	public static boolean isValidCycle(int[] nums, HashMap<Integer, Boolean> map) {
	    if (map.size() < 2) return false;
	    
	    boolean isNegative = false;
	    boolean isPositive = false;
	    for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
	      if (nums[entry.getKey() % nums.length] < 0) {
	        isNegative = true;
	      } else {
	        isPositive = true;
	      }
	    }
	    
	    if (isNegative == true && isPositive == true) {
	      return false;
	    } else if (isNegative == true) {
	      return true;
	    } else if (isPositive == true) {
	      return true;
	    } else {
	      return false;
	    }
	  }
	  
   public static boolean circularArrayLoop(int[] nums) {
      int n = nums.length;
      
      HashMap<Integer, Boolean> map = new HashMap<>();
      
      for (int i = 0; i < n; i++) {
        int startIndex = i;
        int cyclePoint = i;
        boolean selfLoop = false;
        
        while (!map.containsValue(true)) {
          if (map.containsKey(startIndex)) {
              map.put(startIndex, true);
              cyclePoint = startIndex;
          } else {
            map.put(startIndex, false);
          }
          
          int tempIndex = startIndex;
          if (nums[startIndex % n] + startIndex > 0) {
            tempIndex = (nums[startIndex % n] + startIndex) % n;
          } else {
            tempIndex = (nums[startIndex % n] + startIndex) % n + n;
          }
          
          if (tempIndex == startIndex) {
            selfLoop = true;
            break;
          }
          
          startIndex = tempIndex;
        }
        
        if (selfLoop) {
          map = new HashMap<>();
          continue;
        }
        
        if (cyclePoint != i) {
          map = new HashMap<>();
          continue;
        };
        
        if (isValidCycle(nums, map)) {
          return true;
        }
        
        map = new HashMap<>();
      }
      
      return false;
   }

}
