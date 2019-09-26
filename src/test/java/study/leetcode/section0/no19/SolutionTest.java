package study.leetcode.section0.no19;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import study.leetcode.common.ListNode;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution19 solution;

    @Before
    public void setUp() {
        solution = new Solution19();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode result = solution.removeNthFromEnd(head, 1);
        assertNull(result);
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode result = solution.removeNthFromEnd(head, 1);
        assertEquals("1", listToString(result));
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode result = solution.removeNthFromEnd(head, 2);
        assertEquals("2", listToString(result));
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode tmp = head;
        for (int i = 0; i < 9; i++) {
            tmp.next = new ListNode(i + 2);
            tmp = tmp.next;
        }
        tmp.next = null;

        ListNode result = solution.removeNthFromEnd(head, 1);
        assertEquals("123456789", listToString(result));
    }

    @Test
    public void test5() {
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode tmp = head;
        for (int i = 0; i < 9; i++) {
            tmp.next = new ListNode(i + 2);
            tmp = tmp.next;
        }
        tmp.next = null;

        ListNode result = solution.removeNthFromEnd(head, 3);
        assertEquals("1234567910", listToString(result));
    }

    @Test
    public void test6() {
        ListNode head = new ListNode(1);
        head.next = null;
        ListNode tmp = head;
        for (int i = 0; i < 9; i++) {
            tmp.next = new ListNode(i + 2);
            tmp = tmp.next;
        }
        tmp.next = null;

        ListNode result = solution.removeNthFromEnd(head, 10);
        assertEquals("2345678910", listToString(result));
    }

    private static String listToString(ListNode head) {
        String result = "";
        if (head == null) {
            return result;
        }
        ListNode tmp = head;
        while (tmp != null) {
            result += tmp.val;
            tmp = tmp.next;
        }
        return result;
    }
}
