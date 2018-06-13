package study.leetcode35;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution solution;
    int[] test;

    @Before
    public void setUp() {
        solution = new Solution();
        test = new int[]{1, 3, 5, 6};
    }

    @After
    public void tearDown() {
        solution = null;
        test = null;
    }

    @Test
    public void test1() {
        assertEquals(0, solution.searchInsert(test, 1));
    }

    @Test
    public void test2() {
        assertEquals(1, solution.searchInsert(test, 3));
    }

    @Test
    public void test3() {
        assertEquals(2, solution.searchInsert(test, 5));
    }

    @Test
    public void test4() {
        assertEquals(3, solution.searchInsert(test, 6));
    }

    @Test
    public void test5() {
        assertEquals(0, solution.searchInsert(test, 0));
    }

    @Test
    public void test6() {
        assertEquals(4, solution.searchInsert(test, 7));
    }

    @Test
    public void test7() {
        assertEquals(1, solution.searchInsert(test, 2));
    }

    @Test
    public void test8() {
        assertEquals(2, solution.searchInsert(test, 4));
    }

    @Test
    public void test9() {
        int[] tmp = {5};
        assertEquals(0, solution.searchInsert(tmp, 4));
    }

    @Test
    public void test10() {
        int[] tmp = {5};
        assertEquals(0, solution.searchInsert(tmp, 5));
    }

    @Test
    public void test11() {
        int[] tmp = {5};
        assertEquals(1, solution.searchInsert(tmp, 6));
    }
}
