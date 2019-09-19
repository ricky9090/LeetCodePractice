package study.leetcode.no538;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import study.leetcode.common.TreeNode;

import static org.junit.Assert.assertEquals;

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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        solution.convertBST(root);
        assertEquals(18, root.val);
        assertEquals(20, root.left.val);
        assertEquals(13, root.right.val);
    }
}
