package fastSlowPointers;

import java.util.Arrays;

public class DuplicateNumber {
	
	/*
	 * Given an array of integers nums containing n + 1 integers 
	 * where each integer is in the range [1, n] inclusive.

		There is only one repeated number in nums, return this 
		repeated number.
		
		You must solve the problem without modifying the array nums and 
		uses only constant extra space.
		
		 
		
		Example 1
		Input: nums = [1,3,4,2,2]
		Output: 2
		
		Example 2:
		Input: nums = [3,1,3,4,2]
		Output: 3
		
		Example 3:
		Input: nums = [3,3,3,3,3]
		Output: 3
		 
		
		Constraints:
		1 <= n <= 105
		nums.length == n + 1
		1 <= nums[i] <= n
		All the integers in nums appear only once except for precisely 
		one integer which appears two or more times.
		 
		
		Follow up:
		How can we prove that at least one duplicate number must exist in nums?
		Can you solve the problem in linear runtime complexity?
	 */
	// Time complexity -> O(n * log(n)), Space complexity -> O(log(n))
	public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return nums[i];
        }

        return -1;
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}
