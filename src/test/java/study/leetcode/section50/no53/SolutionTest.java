package study.leetcode.section50.no53;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution53 solution;
    Solution53B solutionB;

    @Before
    public void setUp() {
        solution = new Solution53();
        solutionB = new Solution53B();
    }

    @After
    public void tearDown() {
        solution = null;
        solutionB = null;
    }

    @Test
    public void test1() {
        int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assertEquals(6, solution.maxSubArray(test));
        assertEquals(6, solutionB.maxSubArray(test));
    }

    @Test
    public void test2() {
        int[] test = {-1,-2};
        assertEquals(-1, solution.maxSubArray(test));
        assertEquals(-1, solutionB.maxSubArray(test));
    }

    @Test
    public void test3() {
        int[] test = {-1, -1, -2, -2};
        assertEquals(-1, solution.maxSubArray(test));
        assertEquals(-1, solutionB.maxSubArray(test));
    }

    @Test
    public void test4() {
        int[] test = {8, -1, -1, 3};
        assertEquals(9, solution.maxSubArray(test));
        assertEquals(9, solutionB.maxSubArray(test));
    }

    @Test
    public void test5() {
        int[] test = {8, -19, 5, -4, 20};
        assertEquals(21, solution.maxSubArray(test));
        assertEquals(21, solutionB.maxSubArray(test));
    }

    @Test
    public void test6() {
        int[] test = {-3, -2};
        assertEquals(-2, solution.maxSubArray(test));
        assertEquals(-2, solutionB.maxSubArray(test));
    }
}
