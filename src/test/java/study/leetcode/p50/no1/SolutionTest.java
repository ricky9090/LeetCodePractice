package study.leetcode.p50.no1;

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

    /**
     * Continuous indices
     */
    @Test
    public void test1() {
        int[] a = {2, 7, 5, 11};
        int[] result = solution.twoSum(a, 9);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    /**
     * Separate indices
     */
    @Test
    public void test2() {
        int[] a = {2, 7, 5, 11};
        int[] result = solution.twoSum(a, 18);
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
    }

    /**
     * Contain negative number
     */
    @Test
    public void test3() {
        int[] a = {1, -9, 5, 11, 20};
        int[] result = solution.twoSum(a, 11);
        assertEquals(1, result[0]);
        assertEquals(4, result[1]);
    }
}
