package study.leetcode.section50.no96;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>Unique Binary Search Trees</h2>
 * Given n, how many structurally unique <b>BST's</b> (binary search trees) that store values <i>1 ... n</i>?
 * <p>
 * <b>Example:</b>
 * <pre><code>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * </code></pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/unique-binary-search-trees/">
 * Unique Binary Search Trees</a>
 */
public class Solution96 {

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
        gResult.add(1);
        gResult.add(1);
        return g(n);
    }

    private int g(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            if (gResult.size() <= n) {
                int sum = sum(n);
                gResult.add(sum);
                return sum;
            } else {
                return gResult.get(n);
            }
        }
    }

    private int sum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += f(i, n);
        }
        return result;
    }

    private int f(int root, int n) {
        return g(root - 1) * g(n - root);
    }

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(4));
    }
}
