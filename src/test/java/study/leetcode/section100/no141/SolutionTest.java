package study.leetcode.section100.no141;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

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
        assertFalse(solution.hasCycle(null));
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        assertFalse(solution.hasCycle(head));
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        head.next = head;
        assertTrue(solution.hasCycle(head));
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        assertFalse(solution.hasCycle(head));
    }

    @Test
    public void test5() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        assertTrue(solution.hasCycle(head));
    }

    @Test
    public void test6() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        assertFalse(solution.hasCycle(head));
    }

    @Test
    public void test7() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head;
        assertTrue(solution.hasCycle(head));
    }
}
