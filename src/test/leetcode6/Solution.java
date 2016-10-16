package test.leetcode6;

public class Solution {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		
		char[][] board = new char[numRows][s.length()];
		
		int n = 0;
		int rowIndex = 0, colIndex = 0;
		int state = 0;
		while(n < s.length()) {
			if (rowIndex == numRows) {
				rowIndex = numRows - 2;
				colIndex ++;
			}
			if (rowIndex == -1) {
				rowIndex = 1;
			}
			board[rowIndex][colIndex] = s.charAt(n);
			if (state == 0) {
				rowIndex ++;
			} else {
				rowIndex --;
				colIndex ++;
			}
			if (rowIndex == numRows) {
				state = 1;
			}
			if (rowIndex == -1) {
				state = 0;
			}
			
			n++;
		}
		
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
        	for (int j = 0; j < s.length(); j++) {
        		if (board[i][j] != 0) {
        			sBuffer.append(board[i][j]);
        		}
        	}
        }
		return sBuffer.toString();
    }
	
	public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println(test.convert("PAYPALISHIRING", 3));
	}
}
