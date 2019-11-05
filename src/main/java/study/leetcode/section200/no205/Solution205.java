package study.leetcode.section200.no205;

import java.util.*;

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
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 1) {
            return true;
        }
        HashMap<String, List<String>> mapS2T = new HashMap<>();
        HashMap<String, List<String>> mapT2S = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (int i = 0; i < sArray.length; i++) {
            String key = String.valueOf(sArray[i]);
            String value = String.valueOf(tArray[i]);
            if (mapS2T.get(key) == null) {
                List<String> list = new ArrayList<>();
                list.add(value);
                mapS2T.put(key, list);
            } else {
                List<String> list = mapS2T.get(key);
                if (!list.contains(value)) {
                    list.add(value);
                }
            }


            if (mapT2S.get(value) == null) {
                List<String> list = new ArrayList<>();
                list.add(key);
                mapT2S.put(value, list);
            } else {
                List<String> list = mapT2S.get(value);
                if (!list.contains(key)) {
                    list.add(key);
                }
            }

        }

        Set<Map.Entry<String, List<String>>> set = mapS2T.entrySet();
        for (Map.Entry<String, List<String>> entry : set) {
            if (entry.getValue().size() > 1) {
                return false;
            }
        }

        Set<Map.Entry<String, List<String>>> set2 = mapT2S.entrySet();
        for (Map.Entry<String, List<String>> entry : set2) {
            if (entry.getValue().size() > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        System.out.println(solution205.isIsomorphic("ab", "aa"));
    }
}
