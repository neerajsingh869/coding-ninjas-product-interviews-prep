package twoPointers;

public class ValidPalindrome2 {
	
	/*
	 * Given a string s, return true if the s can be palindrome 
	 * after deleting at most one character from it.

		Example 1:
		
		Input: s = "aba"
		Output: true
		
		Example 2:
		
		Input: s = "abca"
		Output: true
		Explanation: You could delete the character 'c'.
		
		Example 3:
		
		Input: s = "abc"
		Output: false
		
		Constraints:
		
		1 <= s.length <= 105
		s consists of lowercase English letters.
	 */
	// Time complexity -> O(n), Space complexity -> O(1)
	public boolean validPalindrome1(String s) {
        int n = s.length();
        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                int start1 = start + 1;
                int end1 = end;
                while (start1 < end1) {
                    if (s.charAt(start1) == s.charAt(end1)) {
                        start1++;
                        end1--;
                    } else {
                        break;
                    }
                }

                if (start1 >= end1) return true;
                else {
                    int start2 = start;
                    int end2 = end - 1;
                    while (start2 < end2) {
                        if (s.charAt(start2) == s.charAt(end2)) {
                            start2++;
                            end2--;
                        } else {
                            break;
                        }
                    }
            
                    if (start2 >= end2) return true;
                    else return false;
                }

            }
        }

        return true;
    }
	
	// Optimized version
	// Time complexity -> O(n), Space complexity -> O(1)
	public boolean validPalindrome2(String s) {
        int n = s.length();
        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return (isPalindrome(s, start + 1, end) || 
                        isPalindrome(s, start, end - 1));
            }

            start++;
            end--;   
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }

}
