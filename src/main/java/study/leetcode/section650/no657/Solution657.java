package study.leetcode.section650.no657;

/**
 * <h2>Robot Return to Origin</h2>
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 * <p>
 * The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
 * <p>
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 * <p>
 * <b>Example 1:</b>
 * <pre>
 * Input: "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
 * </pre>
 * <b>Example 2:</b>
 * <pre>
 * Input: "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/robot-return-to-origin/">
 * Robot Return to Origin</a>
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        if (moves == null) {
            return true;
        }
        if ("".equals(moves)) {
            return true;
        }

        int[] result = {0, 0};
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
        Solution657 test = new Solution657();
        System.out.println(test.judgeCircle("ASAS"));
    }
}
