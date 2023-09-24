package patterns;

import java.util.Scanner;

public class NumberPattern3 {
	
	/*
	 * Print the following pattern
Pattern for N = 4
4 4 4 4 4 4 4 
4 3 3 3 3 3 4 
4 3 2 2 2 3 4 
4 3 2 1 2 3 4 
4 3 2 2 2 3 4 
4 3 3 3 3 3 4 
4 4 4 4 4 4 4 
Input Format :
N (Total no. of rows)
Output Format :
Pattern in N lines
Sample Input 1 :
5
Sample Output 1 :
5 5 5 5 5 5 5 5 5 
5 4 4 4 4 4 4 4 5 
5 4 3 3 3 3 3 4 5 
5 4 3 2 2 2 3 4 5 
5 4 3 2 1 2 3 4 5 
5 4 3 2 2 2 3 4 5 
5 4 3 3 3 3 3 4 5 
5 4 4 4 4 4 4 4 5 
5 5 5 5 5 5 5 5 5 
	 */
	
	public static void printPattern1(int n){
		for (int i = 1; i <= n; i++) {
			int j = 1;
			// decreasing pattern
			for (; j < i; j++) {
				System.out.print(n - j + 1 + " ");
			}
			// constant pattern
			for (; j <= n; j++) {
				System.out.print(n - i + 1 + " ");
			}
			
			// mirror about y axis
			
			j = n - 1;
			// constant pattern
			for (; j > i - 1; j--) {
				System.out.print(n - i + 1 + " ");
			}
			// increasing pattern
			for (; j >= 1; j--) {
				System.out.print(n - j + 1 + " ");
			}

			System.out.println();
		}
		
		// mirror about x axis
		
		for (int i = n - 1; i >= 1; i--) {
			int j = 1;
			// decreasing pattern
			for (; j < i; j++) {
				System.out.print(n - j + 1 + " ");
			}
			// constant pattern
			for (; j <= n; j++) {
				System.out.print(n - i + 1 + " ");
			}
			// mirror about y axis
			j = n - 1;
			// constant pattern
			for (; j > i - 1; j--) {
				System.out.print(n - i + 1 + " ");
			}
			// increasing pattern
			for (; j >= 1; j--) {
				System.out.print(n - j + 1 + " ");
			}

			System.out.println();
		}
	}
	
	// Same approach as above but more readability
	public static void printPattern2(int n){
		for (int i = 1; i <= n; i++) {
			// decreasing pattern
			for (int j = 1; j <= i; j++) {
				System.out.print(n - j + 1 + " ");
			}
			// constant pattern
			for (int j = 1; j <= n - i; j++) {
				System.out.print(n - i + 1 + " ");
			}

			// mirror about y axis

			// constant pattern
			for (int j = 1; j <= n - i; j++) {
				System.out.print(n - i + 1 + " ");
			}
			// increasing pattern
			for (int j = i - 1; j >= 1; j--) {
				System.out.print(n - j + 1 + " ");
			}

			System.out.println();
		}

		// mirror about x axis

		for (int i = n - 1; i >= 1; i--) {
			// decreasing pattern
			for (int j = 1; j <= i; j++) {
				System.out.print(n - j + 1 + " ");
			}
			// constant pattern
			for (int j = 1; j <= n - i; j++) {
				System.out.print(n - i + 1 + " ");
			}

			// take mirror

			// constant pattern
			for (int j = 1; j <= n - i; j++) {
				System.out.print(n - i + 1 + " ");
			}
			// increasing pattern
			for (int j = i - 1; j >= 1; j--) {
				System.out.print(n - j + 1 + " ");
			}

			System.out.println();

		}
	}
	
	public static void printPattern3(int n){
		int num = n, count = 2*n - 1;
		for (int i = 1; i <= 2*n - 1; i++) {
			// decreasing pattern
			for (int j = n; j > num; j--) {
				System.out.print(j + " ");
			}
			// constant pattern
			for (int j = 1; j <= count; j++) {
				System.out.print(num + " ");
			}
			// increasing pattern
			for (int j = num + 1; j <=n; j++) {
				System.out.print(j + " ");
			}
			
			if (i >= n) {
				num++;
				count += 2;
			} else {
				num--;
				count -= 2;
			}

			System.out.println();
		}
	}
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = s.nextInt();
		printPattern3(n);
		
	}

}
