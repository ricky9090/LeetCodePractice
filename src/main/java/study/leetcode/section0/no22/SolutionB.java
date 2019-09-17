package study.leetcode.section0.no22;

import java.util.ArrayList;
import java.util.List;

public class SolutionB {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<>();
        // 最大组合数 2^(2n),字符串长度2n
        // 从第一个括号开始搜索
        check(2 * n, 0, 0, "", result);

        return result;
    }

    private void check(int loopCount, int currentCount, int currentBalance, String currentStr, List<String> resultList) {
        if (loopCount == currentCount) {  // 当到达最后一个括号时判断
            if (currentBalance == 0) {  // 括号闭合，添加到列表中
                resultList.add(currentStr);
            }
            return;
        }
        if (currentBalance > (loopCount / 2)) {  // 左括号数量大于字符串长度/2，直接跳过
            return;
        }
        int nextCount = currentCount + 1;
        if (currentBalance == 0) {  // 搜索下一个括号字符，当括号闭合时，只搜索左括号
            String str1 = currentStr + "(";
            int nextBalance = ++currentBalance;
            check(loopCount, nextCount, nextBalance, str1, resultList);
        } else { // 搜索两种情况
            String str1 = currentStr + "(";
            String str2 = currentStr + ")";

            int nextBalanceLeft = currentBalance + 1;
            int nextBalanceRight = currentBalance - 1;
            check(loopCount, nextCount, nextBalanceLeft, str1, resultList);
            check(loopCount, nextCount, nextBalanceRight, str2, resultList);
        }

    }

    public static void main(String[] args) {
        SolutionB solution = new SolutionB();
        List<String> result = solution.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
