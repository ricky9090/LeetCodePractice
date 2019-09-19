package study.leetcode.section200.no206;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import study.leetcode.common.ListNode;

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
        assertNull(solution.reverseList(null));
    }

    @Test
    public void test2() {
        ListNode head = new ListNode(5);
        ListNode result = solution.reverseList(head);
        assertEquals(5, result.val);
        assertNull(result.next);
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(4);
        ListNode tmp = head;
        for (int i = 5; i < 20; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        Solution solution = new Solution();
        ListNode result = solution.reverseList(head);
        int answer = 19;
        while (result != null) {
            assertEquals(answer, result.val);
            result = result.next;
            answer--;
        }
    }

}
