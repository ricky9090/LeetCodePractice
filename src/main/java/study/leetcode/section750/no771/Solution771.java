package study.leetcode.section750.no771;

import java.util.HashMap;

/**
 * <h2>Jewels and Stones</h2>
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * </code></pre>
 * <b>Note:</b>
 * <pre>
 *     S and J will consist of letters and have length at most 50.
 *     The characters in J are distinct.
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/jewels-and-stones/">
 * Jewels and Stones</a>
 */
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        char[] jArray = J.toCharArray();
        HashMap<String, Integer> map = new HashMap<>();
        for (char j : jArray) {
            map.put(String.valueOf(j), 0);
        }

        char[] sArray = S.toCharArray();
        int count = 0;
        for (char s : sArray) {
            if (map.get(String.valueOf(s)) != null) {
                count++;
            }
        }

        return count;
    }
}
