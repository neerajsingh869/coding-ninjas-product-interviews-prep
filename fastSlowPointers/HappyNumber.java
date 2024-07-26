package fastSlowPointers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	
	/*
	 * 	Write an algorithm to determine if a number n is happy.

		A happy number is a number defined by the following process:
			
			Starting with any positive integer, replace the number 
			by the sum of the squares of its digits.
			
			Repeat the process until the number equals 1 (where it will stay), 
			or it loops endlessly in a cycle which does not include 1.
			
			Those numbers for which this process ends in 1 are happy.
			Return true if n is a happy number, and false if not.
		
		 
		
		Example 1:
		
		Input: n = 19
		Output: true
		Explanation:
		12 + 92 = 82
		82 + 22 = 68
		62 + 82 = 100
		12 + 02 + 02 = 1
		Example 2:
		
		Input: n = 2
		Output: false
		 
		
		Constraints:
		
		1 <= n <= 231 - 1
	 */
	// Time complexity -> O(log n), Space complexity -> O(log n)
	public boolean isHappy1(int n) {
        long number = n;

        Set<Long> store = new HashSet<>();
        store.add(number);

        while (number != 1) {
            number = sumOfSquareDigits(number);

            if (store.contains(number)) {
                return false;
            }

            store.add(number);
        }

        if (number == 1) return true;

        return false;
    }
    
	// Time complexity -> O(log n), Space complexity -> O(1)
    public static boolean isHappy2(int num) {
    	long slow = num;
    	long fast = sumOfSquareDigits(num);

        while (fast != 1 && fast != slow) {
            slow = sumOfSquareDigits(slow);
            fast = sumOfSquareDigits(sumOfSquareDigits(fast));
        }

        return fast == 1;
    }

    public static long sumOfSquareDigits(long num) {
        long totalSum = 0;

        while (num > 0) {
        	long lastDigit = num % 10;
            num /= 10;

            totalSum += lastDigit * lastDigit;
        }

        return totalSum;
    }

}
