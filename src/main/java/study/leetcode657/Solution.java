package study.leetcode657;

public class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null) {
            return true;
        }
        if ("".equals(moves)) {
            return true;
        }
        
        int[] result = {0,0};
        char[] movements = moves.toCharArray();
        for (int i = 0; i < moves.length(); i++) {
            switch (movements[i]) {
            case 'U':
                result[0] += 1;
                break;
            case 'D':
                result[0] -= 1;
                break;
            case 'L':
                result[1] -= 1;
                break;
            case 'R':
                result[1] += 1;
                break;
            default:
                break;
            }
        }
        if (result[0] == 0 && result[1] == 0) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.judgeCircle("ASAS"));
    }
}
