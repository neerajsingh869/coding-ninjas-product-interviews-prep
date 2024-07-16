package twoPointers;

public class SortColors {
	
	/*
	 * Given an array, colors, which contains a combination of the following three elements:
		0
		 (representing red)
		1
		 (representing white)
		2
		 (representing blue)
		
		Sort the array in place so that the elements of the same color are adjacent, 
		with the colors in the order of red, white, and blue. To improve your 
		problem-solving skills, do not utilize the built-in sort function.
	
	 */
	// Time complexity -> O(n), Space complexity -> O(1)
	public void sortColors1(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public static int[] sortColors2(int[] colors) {
		// arr[0...start - 1] will have all 0s
		// arr[start...current - 1] will have all 1s
		// arr[current...end] will have any num 0/1/2
		// arr[end + 1...n - 1] will have all 2s
        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        while (current <= end) {
            if (colors[current] == 0) {
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;
                
                current++;
                start++;
            }

            else if (colors[current] == 1) {
                current++;
            }

            else {
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;

                end--;
            }
        }

        return colors;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
            {0, 1, 0},
            {1, 1, 0, 2},
            {2, 1, 1, 0, 0},
            {2, 2, 2, 0, 1, 0},
            {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + inputs[i]);

            int[] sortedColors = sortColors2(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + sortedColors);
        }
    }
}
