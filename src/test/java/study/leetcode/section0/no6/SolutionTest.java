package study.leetcode.section0.no6;

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
        String result = solution.convert("PAYPALISHIRING", 3);
        assertEquals("PAHNAPLSIIGYIR", result);
    }

    @Test
    public void test2() {
        String result = solution.convert("PAYPALISHIRING", 4);
        assertEquals("PINALSIGYAHRPI", result);
    }

    @Test
    public void test3() {
        String result = solution.convert("PAYPA", 3);
        assertEquals("PAAPY", result);
    }

    @Test
    public void test4() {
        String result = solution.convert("PAYPALISHIRING", 1);
        assertEquals("PAYPALISHIRING", result);
    }
}
