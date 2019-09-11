package study.leetcode.section300.no303;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    NumArray solution;

    @Before
    public void setUp() {
        int[] testArray = {-2, 0, 3, -5, 2, -1};
        solution = new NumArray(testArray);
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        assertEquals(1, solution.sumRange(0, 2));
    }

    @Test
    public void test2() {
        assertEquals(-1, solution.sumRange(2, 5));
    }

    @Test
    public void test3() {
        assertEquals(-3, solution.sumRange(0, 5));
    }
}
