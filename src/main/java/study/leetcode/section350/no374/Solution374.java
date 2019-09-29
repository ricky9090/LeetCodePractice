package study.leetcode.section350.no374;


/**
 * We are playing the Guess Game. The game is as follows:<br>
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.<br>
 * <p>
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.<br>
 * <p>
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):<br>
 * <p>
 * -1 : My number is lower<br>
 * &nbsp 1 : My number is higher<br>
 * &nbsp 0 : Congrats! You got it!<br>
 * Example :<br>
 * <p>
 * Input: n = 10, pick = 6<br>
 * Output: 6<br>
 *
 * @see <a href="https://leetcode.com/problems/guess-number-higher-or-lower/">
 * Guess Number Higher or Lower</a>
 */
public class Solution374 extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int result = this.guess(middle);
            if (result == -1) {
                right = middle - 1;
            } else if (result == 1) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO
    }
}
