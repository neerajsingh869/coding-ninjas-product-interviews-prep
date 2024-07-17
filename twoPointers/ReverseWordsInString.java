package twoPointers;

import java.util.Arrays;
import java.util.List;

public class ReverseWordsInString {
	
	/*
	 * Given an input string s, reverse the order of the words.

		A word is defined as a sequence of non-space characters. 
		The words in s will be separated by at least one space.
		
		Return a string of the words in reverse order concatenated 
		by a single space.
		
		Note that s may contain leading or trailing spaces or multiple 
		spaces between two words. The returned string should only have 
		a single space separating the words. Do not include any extra spaces.
		
		 
		
		Example 1:
		
		Input: s = "the sky is blue"
		Output: "blue is sky the"
		Example 2:
		
		Input: s = "  hello world  "
		Output: "world hello"
		Explanation: Your reversed string should not contain 
		leading or trailing spaces.
		Example 3:
		
		Input: s = "a good   example"
		Output: "example good a"
		Explanation: You need to reduce multiple spaces between 
		two words to a single space in the reversed string.
		 
		
		Constraints:
		
		1 <= s.length <= 104
		s contains English letters (upper-case and lower-case), 
		digits, and spaces ' '.
		There is at least one word in s.
	 */
	// Time complexity -> O(n) in case each characters are separated by space
	// Space complexity -> O(n * n)
	public static String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");

        String ans = "";
        for (String word : words) {
            ans = word + " " + ans;
        }

        return ans.trim();
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String reverseWords2(String s) {
		String[] words = s.trim().split("\\s+");
		
		StringBuilder ans = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			ans.append(words[i]).append(" ");
		}
		
		return ans.toString().trim();
	}
	
	// Time complexity -> O(n), Space complexity -> O(n * n)
	public static String reverseWords3(String sentence) {
        sentence = sentence.trim();

        String ans = "";
        int start = 0;
        int end = 0;
        int n = sentence.length();

        while (end < n) {
            if (sentence.charAt(end) == ' ') {
                ans = sentence.substring(start, end) + " " + ans;

                end++;
                while (end < n && sentence.charAt(end) == ' ') {
                    end++;
                }

                start = end;
            }

            end++;
        }

        ans = sentence.substring(start, end) + " " + ans;

        return ans.trim();
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static String reverseWords4(String sentence) {
        // Remove extra spaces and strip leading/trailing spaces
        sentence = sentence.replaceAll("\\s+", " ").trim();

        // Convert the sentence to a character array 
        // for in-place modification as strings are immutable in Java
        char[] charArray = sentence.toCharArray();
        int strLen = charArray.length - 1;

        // Reverse the whole sentence first
        strRev(charArray, 0, strLen);

        // Iterate through the sentence to find and reverse each word
        for (int start = 0, end = 0; end <= strLen; ++end) {
            if (end == strLen || charArray[end] == ' ') {
                // Include end character for the last word
                int endIdx = (end == strLen ) ? end : end - 1;
                // Reverse the current word
                strRev(charArray, start, endIdx);
                // Move the "start" pointer to the start of the next word
                start = end + 1;
            }
        }

        return new String(charArray);
    }
	
	// A function that reverses characters from startRev to endRev in place
    private static void strRev(char[] str, int startRev, int endRev) {
        while (startRev < endRev) {
            char temp = str[startRev];
            str[startRev] = str[endRev];
            str[endRev] = temp;
            startRev++;
            endRev--;
        }
    }
    
    // Time complexity -> O(n), Space complexity -> O(n)
    public static String reverseWords5(String s) {
        s = s.replaceAll("\\s+", " ").trim();

        char[] sentence = s.toCharArray();
        int n = sentence.length;

        // reverse sentence
        strRev(sentence, 0, n - 1);

        // traverse character array using two pointers
        // and reverse each individual words to get 
        // desired result
        int start = 0;
        int end = 0;

        while (end < n) {
            if (end == n - 1 || sentence[end] == ' ') {
                int endNew = (end == n - 1) ? end : end - 1;

                strRev(sentence, start, endNew);

                start = end + 1;
            }

            end++;
        }

        // return output after converting char array
        // into string
        return new String(sentence);
    }
    
    // Driver code
    public static void main(String[] args) {
        List<String> stringsToReverse = Arrays.asList(
            "Hello World",
            "a   string   with   multiple   spaces",
            "Case Sensitive Test 1234",
            "a 1 b 2 c 3 d 4 e 5",
            "     trailing spaces",
            "case test interesting an is this"
        );

        for (int i = 0; i < stringsToReverse.size(); i++) {
            System.out.println((i + 1) + ".\tOriginal string: '" + stringsToReverse.get(i) + "'");
            System.out.println("\tReversed string: '" + reverseWords5(stringsToReverse.get(i)) + "'");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
