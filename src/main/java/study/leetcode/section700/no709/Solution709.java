package study.leetcode.section700.no709;

/**
 * <h2>To Lower Case</h2>
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: "Hello"
 * Output: "hello"
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: "here"
 * Output: "here"
 * </code></pre>
 * <b>Example 3:</b>
 * <pre><code>
 * Input: "LOVELY"
 * Output: "lovely"
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/to-lower-case/">
 * To Lower Case</a>
 */
public class Solution709 {
    public String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }

        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] = (char) (array[i] + 32);
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        Solution709 solution709 = new Solution709();
        System.out.println(solution709.toLowerCase("Hello"));
    }
}
