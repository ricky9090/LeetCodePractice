package study.leetcode.section50.no66;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution66 solution;

    @Before
    public void setUp() {
        solution = new Solution66();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        int[] test = {1, 2, 3};
        int[] result = solution.plusOne(test);
        assertEquals("", "124", getDigitResult(result));
    }

    @Test
    public void test2() {
        int[] test = {9, 9, 9};
        int[] result = solution.plusOne(test);
        assertEquals("", "1000", getDigitResult(result));
    }

    @Test
    public void test3() {
        int[] test = {1, 8, 9};
        int[] result = solution.plusOne(test);
        assertEquals("", "190", getDigitResult(result));
    }

    private String getDigitResult(int[] result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i: result) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
