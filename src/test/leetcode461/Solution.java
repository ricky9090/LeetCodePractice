package test.leetcode461;

public class Solution {
	/**
	 * 0 <= x,y <= 2^31
	 * */
	public int hammingDistance(int x, int y) {
		if (x == 0 && y == 0) {
			return 0;
		}
		
		// ʹ����������洢������λ
		int[] a = new int[31];
		int[] b = new int[31];

		// �����Ϊ��ʼ��ÿ�ν�һλ�������λ�ã�
		// ����1������������õ���һλ��ֵ
		for (int index = 0; index < 31; index++) {
			a[index] = (x >> (31-index-1)) & 1;
			b[index] = (y >> (31-index-1)) & 1;
		}
		
		// ����λ���飬ͳ��λ����ͬ����
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
