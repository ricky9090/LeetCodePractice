package study.leetcode.p50.no20;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * 1. Open brackets must be closed by the same type of brackets.
 * <p>
 * 2. Open brackets must be closed in the correct order.
 * <p>
 * Note that an empty string is also considered valid.
 *
 * @see <a href="https://leetcode.com/problems/valid-parentheses/description/">
 * Valid Parentheses - LeetCode</a>
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        int level = 0;
        int[] openStack = new int[s.length()];
        int[] closeStack = new int[s.length()];
        char[] array = s.toCharArray();
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
                openStack[level] = typeOfBrackets(array[i]);
                level++;
                continue;
            }
            if (array[i] == ')' || array[i] == '}' || array[i] == ']') {
                // 避免字符串末尾多余右括号造成closeStack[-1] ArrayIndexOutOfBoundsException
                if (level == 0) {
                    return false;
                }
                closeStack[level - 1] = typeOfBrackets(array[i]);
                if (closeStack[level - 1] != openStack[level - 1]) {
                    return false;
                }
                level--;
                continue;
            }
        }
        if (level == 0) {
            result = true;
        }
        return result;
    }

    private static int typeOfBrackets(char target) {
        switch (target) {
            case '(':
            case ')':
                return 1;
            case '{':
            case '}':
                return 2;
            case '[':
            case ']':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("("));
        System.out.println(solution.isValid(")"));
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("(}"));
        System.out.println(solution.isValid("())"));
        System.out.println(solution.isValid("([{}()])"));
    }
}
