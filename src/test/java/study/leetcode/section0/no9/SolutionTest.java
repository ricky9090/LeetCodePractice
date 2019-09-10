package study.leetcode.section0.no9;

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
        assertTrue(solution.isPalindrome(121));
    }

    @Test
    public void test2() {
        assertFalse(solution.isPalindrome(-121));
    }

    @Test
    public void test3() {
        assertFalse(solution.isPalindrome(10));
    }

    @Test
    public void test4() {
        assertTrue(solution.isPalindrome(34543));
    }

    @Test
    public void test5() {
        assertFalse(solution.isPalindrome(12345));
    }
}

