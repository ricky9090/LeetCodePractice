package study.leetcode.section150.no169;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution169 solution;

    @Before
    public void setUp() {
        solution = new Solution169();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        int test[] = {3, 2, 3};
        assertEquals(3, solution.majorityElement(test));
    }

    @Test
    public void test2() {
        int test[] = {2, 2, 1, 1, 1, 2, 2};
        assertEquals(2, solution.majorityElement(test));
    }
}
