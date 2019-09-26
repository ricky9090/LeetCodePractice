package study.leetcode.section0.no14;

/**
 * <h2>Longest Common Prefix</h2>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * </code></pre>
 *
 * <b>Example 2:</b>
 * <pre><code>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * </code></pre>
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * <b>Note:</b>
 * <p>
 * All given inputs are in lowercase letters a-z.
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-common-prefix">
 * Longest Common Prefix</a>
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String flagStr = null;
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLength) {
                minLength = s.length();
                flagStr = s;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            boolean equals = true;
            char flag = flagStr.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != flag) {
                    equals = false;
                    break;
                }
            }
            if (equals) {
                stringBuilder.append(flag);
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] test = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        String[] test3 = {"aca", "cba"};
        Solution14 solution = new Solution14();
        System.out.println(solution.longestCommonPrefix(test));
        System.out.println(solution.longestCommonPrefix(test2));
        System.out.println(solution.longestCommonPrefix(test3));
    }
}
