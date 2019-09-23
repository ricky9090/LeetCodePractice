package study.leetcode.section0.no17;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Letter Combinations of a Phone Number</h2>
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.<br>
 * Note that 1 does not map to any letters.
 * <p>
 * <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png" alt="">
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * </code></pre>
 * Note:
 * <p>
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * @see <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number">
 * Letter Combinations of a Phone Number</a>
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }

        char[] digitsChars = digits.toCharArray();

        search(digitsChars, 0, "", result);
        return result;
    }

    private void search(final char[] targetArray, int currentIndex, String combination, List<String> result) {
        if (currentIndex >= targetArray.length) {
            result.add(combination);
            return;
        }

        char charAtIndex = targetArray[currentIndex];
        String letterStr = getLetterStringForChar(charAtIndex);
        char[] letterArray = letterStr.toCharArray();
        for (char c : letterArray) {
            String next = combination + c;
            search(targetArray, currentIndex + 1, next, result);
        }


    }

    private String getLetterStringForChar(char num) {
        switch (num) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Solution17 solution = new Solution17();
        List<String> result = solution.letterCombinations("23");
        System.out.println(result);
    }
}
