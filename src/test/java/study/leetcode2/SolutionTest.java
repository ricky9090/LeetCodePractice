package study.leetcode2;

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

    /**
     * Example test
     */
    @Test
    public void test1() {
        ListNode l1;
        ListNode l2;
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = solution.addTwoNumbers(l1, l2);
        // 465 + 342 = 807, reverse order "708"
        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
    }

    /**
     * Test carry, carry on leading digital, 3 digital -> 4 digital
     */
    @Test
    public void test2() {
        ListNode l1;
        ListNode l2;
        l1 = new ListNode(0);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(9);

        l2 = new ListNode(3);
        l2.next = new ListNode(5);

        ListNode result = solution.addTwoNumbers(l1, l2);
        // 980 + 53 = 1033, reverse order "3301"
        assertEquals(3, result.val);
        assertEquals(3, result.next.val);
        assertEquals(0, result.next.next.val);
        assertEquals(1, result.next.next.next.val);
    }

    /**
     * Test carry, multiple carries, 3 digital -> 4 digital
     */
    @Test
    public void test3() {
        ListNode l1;
        ListNode l2;
        l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(9);

        l2 = new ListNode(3);
        l2.next = new ListNode(5);

        ListNode result = solution.addTwoNumbers(l1, l2);
        // 989 + 53 = 1042, reverse order "2401"
        assertEquals(2, result.val);
        assertEquals(4, result.next.val);
        assertEquals(0, result.next.next.val);
        assertEquals(1, result.next.next.next.val);
    }
}
