package study.leetcode.section0.no13;

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
        assertEquals(3, solution.romanToInt("III"));
    }

    @Test
    public void test2() {
        assertEquals(4, solution.romanToInt("IV"));
    }

    @Test
    public void test3() {
        assertEquals(9, solution.romanToInt("IX"));
    }

    @Test
    public void test4() {
        assertEquals(58, solution.romanToInt("LVIII"));
    }

    @Test
    public void test5() {
        assertEquals(1994, solution.romanToInt("MCMXCIV"));
    }

    @Test
    public void test6() {
        assertEquals(3999, solution.romanToInt("MMMCMXCIX"));
    }
}
