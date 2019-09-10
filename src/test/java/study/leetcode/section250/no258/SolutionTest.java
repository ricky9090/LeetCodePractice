package study.leetcode.section250.no258;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
        assertEquals(2, solution.addDigits(38));
    }

    @Test
    public void test2() {
        assertEquals(9, solution.addDigits(99));
    }

    @Test
    public void test3() {
        assertEquals(9, solution.addDigits(252));
    }

    @Test
    public void test4() {
        assertEquals(7, solution.addDigits(1024));
    }

    @Test
    public void test5() {
        assertEquals(5, solution.addDigits(2048));
    }
}
