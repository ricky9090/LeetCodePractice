package study.leetcode.section50.no96;

import java.util.ArrayList;
import java.util.List;

public class Solution96B {
    /*
    result = g(n)
    0 -> 0
    1 -> 1
    2 -> g(0)_1_g(1) + g(1)_2_g(0)
    3 -> g(0)_1_g(2) + g(1)_2_g(1) + g(2)_3_g(0)
    g(n)  => g(0)_1_g(n - 1) + ... + g(root - 1)_root_g(n - root)

    g(root - 1)_root_g(n - root) = g(root - 1)g(n - root)
    g(root - 1)_root_g(n - root) => f(root, n)
    f(root, n) = g(root - 1)g(n - root)

    g(0) = 0 => g(0) = 1
    g(1) = 1
    g(n) => g(0)_1_g(n - 1) + ... + g(root - 1)_root_g(n - root)
         => f(1, n) + ...+ f(n, n)

     */

    private List<Integer> gResult = new ArrayList<>();

    public int numTrees(int n) {
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                gResult.add(1);
                continue;
            }
            int gN = 0;
            for (int j = 1; j <= i; j++) {
                gN += gResult.get(j - 1) * gResult.get(i - j);
            }
            gResult.add(gN);
        }
        return gResult.get(gResult.size() - 1);
    }

    public static void main(String[] args) {
        Solution96B solution96B = new Solution96B();
        System.out.println(solution96B.numTrees(4));
    }
}
