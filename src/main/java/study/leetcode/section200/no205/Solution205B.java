package study.leetcode.section200.no205;

import java.util.HashMap;
import java.util.List;

/**
 * <h2>Isomorphic Strings</h2>
 * Given two strings <b>s</b> and <b>t</b>, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * <b>Example 1:</b>
 * <pre><code>
 * Input: s = "egg", t = "add"
 * Output: true
 * </code></pre>
 * <b>Example 2:</b>
 * <pre><code>
 * Input: s = "foo", t = "bar"
 * Output: false
 * </code></pre>
 * <b>Example 3:</b>
 * <pre><code>
 * Input: s = "paper", t = "title"
 * Output: true
 * </code></pre>
 * <b>Note:</b>
 * You may assume both s and t have the same length.
 *
 * @see <a href="https://leetcode-cn.com/problems/isomorphic-strings/">
 * Isomorphic Strings</a>
 */
public class Solution205B {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 1) {
            return true;
        }
        HashMap<String, List<String>> mapS2T = new HashMap<>();
        HashMap<String, List<String>> mapT2S = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            if (s.indexOf(sArray[i]) != t.indexOf(tArray[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205B solution205B = new Solution205B();
        System.out.println(solution205B.isIsomorphic("ab", "aa"));
        System.out.println(solution205B.isIsomorphic("aa", "ab"));
        System.out.println(solution205B.isIsomorphic("title", "paper"));
        System.out.println(solution205B.isIsomorphic("egg", "add"));
    }
}
