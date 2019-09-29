package study.leetcode.no617;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import study.leetcode.common.TreeNode;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution617 solution;

    @Before
    public void setUp() {
        solution = new Solution617();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        assertNull(solution.mergeTrees(null, null));
    }

    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(1);
        TreeNode result = solution.mergeTrees(t1, null);
        assertEquals(1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(4);
        t2.right = new TreeNode(6);

        TreeNode result = solution.mergeTrees(t1, t2);
        assertEquals(5, result.val);
        assertEquals(2, result.left.val);
        assertEquals(9, result.right.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertNull(result.right.left);
        assertNull(result.right.right);
    }
}
