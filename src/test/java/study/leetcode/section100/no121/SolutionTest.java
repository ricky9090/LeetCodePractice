package study.leetcode.section100.no121;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    private Solution121 solution;

    @Before
    public void setUp() {
        solution = new Solution121();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        int[] test = {7, 1, 5, 3, 6, 4};
        assertEquals(5, solution.maxProfit(test));
    }

    @Test
    public void test2() {
        int[] test = {7, 6, 4, 3, 1};
        assertEquals(0, solution.maxProfit(test));
    }
}
