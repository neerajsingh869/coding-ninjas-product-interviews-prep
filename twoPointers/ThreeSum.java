package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	
	/*
	 * Given an integer array nums, return all the triplets 
	 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, 
	 * and nums[i] + nums[j] + nums[k] == 0.

		Notice that the solution set must not contain duplicate triplets.

		Example 1:
		
		Input: nums = [-1,0,1,2,-1,-4]
		Output: [[-1,-1,2],[-1,0,1]]
		Explanation: 
		nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
		nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
		nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
		The distinct triplets are [-1,0,1] and [-1,-1,2].
		Notice that the order of the output and the order of the triplets does not matter.
		
		Example 2:
		
		Input: nums = [0,1,1]
		Output: []
		Explanation: The only possible triplet does not sum up to 0.
		
		Example 3:
		
		Input: nums = [0,0,0]
		Output: [[0,0,0]]
		Explanation: The only possible triplet sums up to 0.
		 
		
		Constraints:
		
		3 <= nums.length <= 3000
		-105 <= nums[i] <= 105
	 */
	
	public static List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ansSet = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = 
                            Arrays.asList(nums[i], nums[j], nums[k]);

                        Collections.sort(temp);

                        ansSet.add(temp);
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>(ansSet);
        return result;
    }
	
	// Best approach (Time complexity -> O(n*n*m), Space complexity -> O(m))
	// Here, m is number of unique elements in set
	public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ansSet = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = n - 1;;

                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[low], nums[high]);

                        Collections.sort(temp);

                        ansSet.add(temp);

                        low++;
                        high--;
                        
                        // skip the duplicates
                        while (low < high && nums[low - 1] == nums[low]) low++;
                        while (low < high && nums[high + 1] == nums[high]) high--;
                    } else if (sum > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>(ansSet);
        return result;
    }

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4};
		
        List<List<Integer>> ans = threeSum1(arr);
        
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
	}

}
