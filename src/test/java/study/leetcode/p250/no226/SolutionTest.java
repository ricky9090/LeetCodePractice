package study.leetcode.p250.no226;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution solution;

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        assertNull(solution.invertTree(null));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        solution.invertTree(root);
        assertEquals(3, root.left.val);
        assertEquals(2, root.right.val);
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(3);

        solution.invertTree(root);
        assertEquals(3, root.left.val);
        assertNull(root.right);
    }

}
