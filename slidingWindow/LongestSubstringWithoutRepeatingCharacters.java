package slidingWindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	
	/*
	 * Given a string s, find the length of the longest substring
	   without repeating characters.
		 
		
		Example 1:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.
		
		Example 2:
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		
		Example 3:
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
		 
		
		Constraints:
		0 <= s.length <= 5 * 104
		s consists of English letters, digits, symbols and spaces.
	 */
    
	// Time complexity -> O(n), Space complexity -> O(n)
	public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int i = 0;
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                int tempIdx = map.get(s.charAt(i)) + 1;

                // to prevent concurrentModificationException error
                Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Character, Integer> entry = iterator.next();
                    if (entry.getValue() < tempIdx) {
                        iterator.remove();
                    }
                }
            }
            map.put(s.charAt(i), i);

            maxLength = Math.max(maxLength, map.size());
            i++;
        }

        return maxLength;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int lengthOfLongestSubstring3(String s) {
        int n = s.length();

        int maxLength = 0;
        int start = 0;
        int end = 0;
        while (end < n) {
            int j = end - 1;
            while (j >= start) {
                if (s.charAt(j) == s.charAt(end)) {
                    start = j + 1;
                    break;
                }

                j--;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public int lengthOfLongestSubstring4(String s) {
		HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) {
            	left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            }

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
	}
}
