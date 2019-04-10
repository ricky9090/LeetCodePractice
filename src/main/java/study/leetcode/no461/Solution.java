package study.leetcode.no461;

public class Solution {
    /**
     * 0 <= x,y <= 2^31
     * */
    public int hammingDistance(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        
        // 使用两个数组存储位值
        int[] a = new int[31];
        int[] b = new int[31];

        // 从最高位开始遍历，将位右移至最低位
        // 再和1进行位与，得到此位的值
        for (int index = 0; index < 31; index++) {
            a[index] = (x >> (31-index-1)) & 1;
            b[index] = (y >> (31-index-1)) & 1;
        }
        
        // 遍历统计不同位个数
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
