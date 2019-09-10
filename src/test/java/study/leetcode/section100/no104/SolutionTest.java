package study.leetcode.section100.no104;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution solution;
    SolutionB solutionB;

    @Before
    public void setUp() {
        solution = new Solution();
        solutionB = new SolutionB();
    }

    @After
    public void tearDown() {
        solution = null;
        solutionB = null;
    }

    @Test
    public void test1() {
        assertEquals(0, solution.maxDepth(null));
        assertEquals(0, solutionB.maxDepth(null));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, solution.maxDepth(root));
        assertEquals(1, solutionB.maxDepth(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        assertEquals(4, solution.maxDepth(root));
        assertEquals(4, solutionB.maxDepth(root));
    }
}
