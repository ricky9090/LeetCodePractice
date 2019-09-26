package study.leetcode.section50.no58;

/**
 * <h2>Length of Last Word</h2>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * <b>Note:</b> A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: "Hello World"
 * Output: 5
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/length-of-last-word">
 * Length of Last Word</a>
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        int result = 0;
        if (s == null || "".equals(s)) {
            return result;
        }

        char[] array = s.toCharArray();
        int lastAlphaIndex = 0;
        for (int i = array.length - 1; i >= 0; i--) {  // trim
            if (array[i] != ' ') {
                lastAlphaIndex = i;
                break;
            }
        }

        int lastSpaceIndex = -1;
        for (int i = lastAlphaIndex; i >= 0; i--) {
            if (array[i] == ' ') {
                lastSpaceIndex = i;
                break;
            }
        }

        return lastAlphaIndex - lastSpaceIndex;
    }

    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        System.out.println(solution.lengthOfLastWord("Hello world"));
        System.out.println(solution.lengthOfLastWord("a "));
        System.out.println(solution.lengthOfLastWord("a"));
        System.out.println(solution.lengthOfLastWord("     "));
        System.out.println(solution.lengthOfLastWord("b   a    "));
    }
}
