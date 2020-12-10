package com.cts.mytest.main;

public class Snippet {
	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		smallest = s.substring(0, k - 1);
		largest = s.substring(0, k - 1);
		for (int i = 0; i < s.length() - k + 1; i++) {
			if (smallest.compareTo(s.substring(i, k + i)) > 1) {
				smallest = s.substring(i, k + i);
			}
			if (largest.compareTo(s.substring(i, k + i)) < 1) {
				largest = s.substring(i, k + i);
			}
			// System.out.println(smallest + " " + largest);
		}
		return smallest + " " + largest;
	}

	/*
	 * public void main(String[] args) { String s1 = "welcometojava";
	 * System.out.println(getSmallestAndLargest(s1, 3)); }
	 */
}
