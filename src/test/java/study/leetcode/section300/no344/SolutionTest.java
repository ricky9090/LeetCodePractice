package study.leetcode.section300.no344;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution344 solution;

    @Before
    public void setUp() {
        solution = new Solution344();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        assertEquals("", "olleH", solution.reverseString("Hello"));
    }

    @Test
    public void test2() {
        assertEquals("", "!dlroW,olleH", solution.reverseString("Hello,World!"));
    }
}
