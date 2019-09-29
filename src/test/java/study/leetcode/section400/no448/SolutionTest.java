package study.leetcode.section400.no448;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution448 solution;

    @Before
    public void setUp() {
        solution = new Solution448();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        int[] test = new int[0];
        List<Integer> result = solution.findDisappearedNumbers(test);
        assertEquals(0, result.size());
    }

    @Test
    public void test2() {
        int[] test = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solution.findDisappearedNumbers(test);
        assertEquals(2, result.size());
        assertEquals(5, result.get(0).intValue());
        assertEquals(6, result.get(1).intValue());
    }
}
