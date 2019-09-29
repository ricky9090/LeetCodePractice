package study.leetcode.section150.no155;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    MinStack155 stack;

    @Before
    public void setUp() {
        stack = new MinStack155();
    }

    @After
    public void tearDown() {
        stack = null;
    }

    @Test
    public void test1() {
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3, stack.getMin());
        stack.pop();
        assertEquals(-2, stack.getMin());
        assertEquals(0, stack.top());

    }

    @Test
    public void test2() {
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        assertEquals(0, stack.getMin());
        stack.pop();
        assertEquals(0, stack.getMin());
        stack.pop();
        assertEquals(0, stack.getMin());
        stack.pop();
        assertEquals(2, stack.getMin());
    }
}
