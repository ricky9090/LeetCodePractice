package study.leetcode.section0.no4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution4 solution;

    @Before
    public void setUp() {
        solution = new Solution4();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        int[] a = {1, 2};
        int[] b = {3, 4};
        double result = solution.findMedianSortedArrays(a, b);
        assertEquals(2.5, result, 0.1);
    }

    @Test
    public void test2() {
        int[] a = {-5, -1};
        int[] b = {1, 4};
        double result = solution.findMedianSortedArrays(a, b);
        assertEquals(0, result, 0.1);
    }

    @Test
    public void test3() {
        int[] a = {-5, -1, 0, 1};
        int[] b = {2, 4};
        double result = solution.findMedianSortedArrays(a, b);
        assertEquals(0.5, result, 0.1);
    }

    @Test
    public void test4() {
        int[] a = {-5, -1, 1, 5};
        int[] b = {2, 4};
        double result = solution.findMedianSortedArrays(a, b);
        assertEquals(1.5, result, 0.1);
    }
}
