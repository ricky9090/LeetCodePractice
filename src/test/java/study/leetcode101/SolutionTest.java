package study.leetcode101;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        TreeNode node = new TreeNode(0);
        assertTrue(solution.isSymmetric(node));
        assertTrue(solutionB.isSymmetric(node));
    }

    @Test
    public void test2() {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = null;

        assertFalse(solution.isSymmetric(node));
        assertFalse(solutionB.isSymmetric(node));
    }

    @Test
    public void test3() {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = null;
        node.right.left = null;
        node.right.right = new TreeNode(3);

        assertTrue(solution.isSymmetric(node));
        assertTrue(solutionB.isSymmetric(node));
    }

    @Test
    public void test4() {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = null;
        node.left.right = new TreeNode(4);
        node.right.left = null;
        node.right.right = new TreeNode(3);

        assertFalse(solution.isSymmetric(node));
        assertFalse(solutionB.isSymmetric(node));
    }

    @Test
    public void test5() {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);

        assertTrue(solution.isSymmetric(node));
        assertTrue(solutionB.isSymmetric(node));
    }
}
