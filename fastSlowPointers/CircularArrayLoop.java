package fastSlowPointers;

import java.util.Arrays;
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
	  
   public static boolean circularArrayLoop1(int[] nums) {
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
   
   // Time complexity -> O(n * n), Space complexity -> O(1)
   public static boolean circularArrayLoop2(int[] nums) {
	   int n = nums.length;
	
	   for (int i = 0; i < n; i++) {
	   	int slow = i;
	   	int fast = i;
	   	boolean forward = nums[i] >= 0;
	
	   	while (true) {
	   		slow = nextStep(nums[slow], slow, n);
	   		if (notValidCycle(nums[slow], forward , n)) break;
	
	   		fast = nextStep(nums[fast], fast, n);
	   		if (notValidCycle(nums[fast], forward , n)) break;
	
	   		fast = nextStep(nums[fast], fast, n);
	   		if (notValidCycle(nums[fast], forward , n)) break;
	
	   		if (slow == fast) return true;
	   	}
	   }
	
	   return false;	
   }

   public static int nextStep(int step, int currIdx, int size) {
	   	int nextStep = (currIdx + step) % size;
	   	if (nextStep < 0) nextStep += size;
	
	   	return nextStep;
   }

   public static boolean notValidCycle(int currValue, boolean prevDirection, int size) {
	   	boolean currDirection = currValue >= 0;
	
	   	if (currDirection != prevDirection || Math.abs(currValue % size) == 0) return true;
	
	   	return false;
   }
	   
	// Driver code
    public static void main(String[] args) {
        int[][] input = {
                {-2, -3, -9},
                {-5, -4, -3, -2, -1},
                {-1, -2, -3, -4, -5},
                {2, 1, -1, -2},
                {-1, -2, -3, -4, -5, 6},
                {1, 2, -3, 3, 4, 7, 1},
                {2, 2, 2, 7, 2, -1, 2, -1, -1}
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println((i + 1) + ".\tCircular array = " + Arrays.toString(input[i]) + "\n");
            boolean result = circularArrayLoop2(input[i]);
            System.out.println("\tFound Loop = " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }


}
