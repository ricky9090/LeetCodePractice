package test.leetcode461;

public class Solution {
	/**
	 * 0 <= x,y <= 2^31
	 * */
	public int hammingDistance(int x, int y) {
		if (x == 0 && y == 0) {
			return 0;
		}
		
		// 使用两个数组存储二进制位
		int[] a = new int[31];
		int[] b = new int[31];

		// 从最高为开始，每次将一位移至最低位置，
		// 再与1进行与操作，得到这一位的值
		for (int index = 0; index < 31; index++) {
			a[index] = (x >> (31-index-1)) & 1;
			b[index] = (y >> (31-index-1)) & 1;
		}
		
		// 遍历位数组，统计位不相同数量
		int diffCount = 0;
		for (int i = 0; i < 31; i++) {
			if (a[i] != b[i]) {
				diffCount++;
			}
		}
		return diffCount;
	}
	
	public static void main(String[] args) {
		Solution test = new Solution();
		System.out.println(test.hammingDistance(0, 7));
	}

}
