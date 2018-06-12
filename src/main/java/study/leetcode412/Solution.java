package study.leetcode412;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> array = new ArrayList<String>();
        
        for (int i = 1; i <= n; i++) {
            if ((i%3 == 0) && (i%5 == 0)) {
                array.add("FizzBuzz");
            } else if (i%3 == 0) {
                array.add("Fizz");
            } else if (i%5 == 0) {
                array.add("Buzz");
            } else {
                array.add("" + i);
            }
        }
        
        return array;
        
    }
    
    public static void main(String[] args) {
        List<String> result;
        Solution test = new Solution();
        result = test.fizzBuzz(15);
        for (int i = 0; i < 15; i++) {
            System.out.println(result.get(i));
        }
    }
}
