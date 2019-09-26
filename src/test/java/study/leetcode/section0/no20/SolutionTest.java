package study.leetcode.section0.no20;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution20 solution;

    @Before
    public void setUp() {
        solution = new Solution20();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        assertFalse(solution.isValid("("));
    }

    @Test
    public void test2() {
        assertFalse(solution.isValid(")"));
    }

    @Test
    public void test3() {
        assertTrue(solution.isValid("()"));
    }

    @Test
    public void test4() {
        assertFalse(solution.isValid("(}"));
    }

    @Test
    public void test5() {
        assertFalse(solution.isValid("())"));
    }

    @Test
    public void test6() {
        assertTrue(solution.isValid("([{}()])"));
    }

    @Test
    public void test7() {
        assertFalse(solution.isValid("([{}({)])"));
    }

    @Test
    public void test8() {
        assertTrue(solution.isValid(""));
    }
}
