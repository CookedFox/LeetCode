package io.github.CookedFox.leetcode._682;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Author chenyuxin
 * @Date 2022/4/10 11:10
 * @Email cyx0402@yeah.net
 * @Version v1
 *
 * You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
 * At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
 * An integer x - Record a new score of x.
 * "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
 * "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
 * "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
 * Return the sum of all the scores on the record.
 **/
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String str : ops) {
            switch (str) {
                case "C": {
                    stack.pop();
                    break;
                }
                case "D": {
                    Integer tmp = stack.peek();
                    stack.push(tmp * 2);
                    break;
                }
                case "+": {
                    Integer op2 = stack.get(stack.size() - 1);
                    Integer op1 = stack.get(stack.size() - 2);
                    Integer sum = op2 + op1;
                    stack.push(sum);
                    break;
                }
                default: {
                    stack.push(Integer.valueOf(str));
                }
            }
        }
        int res = 0;
        for (int i = 0; i < stack.size(); i++) {
            res += stack.get(i);
        }

        return res;
    }
}
