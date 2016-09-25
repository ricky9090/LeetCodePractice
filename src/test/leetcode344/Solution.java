package test.leetcode344;

public class Solution {
	
	public String reverseString(String s) {
		char[] input = s.toCharArray();
		int length = input.length;
		
		char[] output = new char[length];
		int o = 0;
		for (int i = length-1; i >=0; i--) {
			output[o++] = input[i];
		}
		return new String(output);
	}
	
	public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println("1: " + test.reverseString("Hello"));
		System.out.println("1: " + test.reverseString("Hello, world!"));
	}

}
