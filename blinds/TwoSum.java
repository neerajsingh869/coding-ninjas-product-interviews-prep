package blinds;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	/*
	 * Given an array of integers nums and an integer target, 
	 * return indices of the two numbers such that they add up to target.

		You may assume that each input would have exactly one solution, 
		and you may not use the same element twice.
		
		You can return the answer in any order.
		
		Example 1:
		
		Input: nums = [2,7,11,15], target = 9
		Output: [0,1]
		Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
		Example 2:
		
		Input: nums = [3,2,4], target = 6
		Output: [1,2]
		Example 3:
		
		Input: nums = [3,3], target = 6
		Output: [0,1]
		
		Constraints:
		
		2 <= nums.length <= 104
		-109 <= nums[i] <= 109
		-109 <= target <= 109
		Only one valid answer exists.
		 
		
		Follow-up: Can you come up with an algorithm that is less 
		than O(n2) time complexity?
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(1)
	public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // If no valid pair is found, return an empty array instead of null
        return new int[] {};
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        // In case there is no solution, return an empty array
        return new int[] {};
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // Return an empty array if no solution is found
        return new int[] {};
    }

}
