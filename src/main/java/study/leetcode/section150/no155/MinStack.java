package study.leetcode.section150.no155;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * </p>
 * <ul>
 * <li>push(x) -- Push element x onto stack.</li>
 * <li>pop() -- Removes the element on top of the stack.</li>
 * <li>top() -- Get the top element.</li>
 * <li>getMin() -- Retrieve the minimum element in the stack.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/min-stack/">
 * Min Stack - LeetCode</a>
 * @see <a href="https://leetcode-cn.com/problems/min-stack/">
 * 最小栈 - LeetCode-cn</a>
 */
class MinStack {

    private List<Integer> dataList;
    private int topIndex = -1;
    private int min = Integer.MAX_VALUE;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataList = new ArrayList<>();

    }

    public void push(int x) {
        dataList.add(x);
        topIndex++;
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        if (topIndex < 0) {
            return;
        }
        int lastValue = dataList.get(topIndex);
        dataList.remove(topIndex);
        topIndex--;
        if (lastValue == min) {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < dataList.size(); i++) {
                int current = dataList.get(i);
                if (current < result) {
                    result = current;
                }
            }
            min = result;
        }
    }

    public int top() {
        if (topIndex < 0) {
            return -1;
        }
        return dataList.get(topIndex);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
