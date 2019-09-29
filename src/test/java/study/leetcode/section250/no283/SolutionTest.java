package study.leetcode.section250.no283;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SolutionTest {
    Solution283 solution;

    @Before
    public void setUp() {
        solution = new Solution283();
    }

    @After
    public void tearDown() {
        solution = null;
    }

    @Test
    public void test1() {
        int question[] = {1};
        int answer[] = {1};
        solution.moveZeroes(question);
        checkAnswer(question, answer);
    }

    @Test
    public void test2() {
        int question[] = {0, 1, 0, 3, 12};
        int answer[] = {1, 3, 12, 0, 0};
        solution.moveZeroes(question);
        checkAnswer(question, answer);
    }

    @Test
    public void test3() {
        int question[] = {0, 0, 1, 3, 12};
        int answer[] = {1, 3, 12, 0, 0};
        solution.moveZeroes(question);
        checkAnswer(question, answer);
    }

    @Test
    public void test4() {
        int question[] = {1, 0, 0, 3, 12};
        int answer[] = {1, 3, 12, 0, 0};
        solution.moveZeroes(question);
        checkAnswer(question, answer);
    }

    @Test
    public void test5() {
        int question[] = {0, 1, 3, 12, 0};
        int answer[] = {1, 3, 12, 0, 0};
        solution.moveZeroes(question);
        checkAnswer(question, answer);
    }

    private void checkAnswer(int[] question, int[] answer) {
        for (int i = 0; i < question.length; i++) {
            assertEquals(question[i], answer[i]);
        }
    }
}
