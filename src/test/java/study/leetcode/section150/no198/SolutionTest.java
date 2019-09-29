package study.leetcode.section150.no198;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    private Solution198 solution;

    @Before
    public void setUp() {
        solution = new Solution198();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        int[] array = {2, 1, 1, 2};
        assertEquals(4, solution.rob(array));
    }

    @Test
    public void test2() {
        int[] array = {1, 2, 3, 1};
        assertEquals(4, solution.rob(array));
    }

    @Test
    public void test3() {
        int[] array = {2, 7, 9, 3, 1};
        assertEquals(12, solution.rob(array));
    }
}
