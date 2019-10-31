package study.leetcode.section350.no389;

public class Solution389B {
    public char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int result = 0;
        for (char a: sArray) {
            result += a;
        }

        for (char b: tArray) {
            result -= b;
        }

        return (char) -result;

    }
}
