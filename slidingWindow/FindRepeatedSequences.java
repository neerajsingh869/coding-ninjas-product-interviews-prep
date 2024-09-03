package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatedSequences {
	
	/*
	 * Given a string, dna, that represents a DNA subsequence, 
	 * and a number k, return all the contiguous subsequences 
	 * (substrings) of length k that occur more than once in the string. 
	 * The order of the returned subsequences does not matter. 
	 * If no repeated substring is found, the function should return an empty set.
	 */
	// Time complexity -> O(n * k) Space complexity -> O(n - k)
	public static Set<String> findRepeatedSequences1(String dna, int k) {
     Set<String> ans = new HashSet<>();
     Set<String> temp = new HashSet<>();
     int n = dna.length();
     
     for (int i = 0; i < n; i++) {
       String tempStr = "";
       
       int j = 0;
       for (; j < k; j++) {
         if (i + j >= n) break;
         tempStr += dna.charAt(i + j);
       }
       
       if (j == k) {
         if (temp.contains(tempStr)) {
           ans.add(tempStr);
         } else {
           temp.add(tempStr);
         }
       }
     }
     
      return ans;
   }
	
	// Time complexity -> O(n * k) Space complexity -> O(n - k)
	public static Set<String> findRepeatedSequences2(String dna, int k) {
     Set<String> ans = new HashSet<>();
     Set<String> temp = new HashSet<>();
     int n = dna.length();
     
     for (int i = 0; i <= n - k; i++) {
       String tempStr = "";
       
       int j = 0;
       for (; j < k; j++) {
         tempStr += dna.charAt(i + j);
       }
       
       if (temp.contains(tempStr)) {
	       ans.add(tempStr);
	     } else {
	       temp.add(tempStr);
	     }
     }
     
      return ans;
   }

}
