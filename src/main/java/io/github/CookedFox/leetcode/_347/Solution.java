package io.github.CookedFox.leetcode._347;

import java.util.*;

/**
 * @ClassName Solution
 * @Author chenyuxin
 * @Date 2022/4/10 11:10
 * @Email cyx0402@yeah.net
 * @Version v1
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 **/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] results = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (e1, e2) -> {
            return e2.getValue() - e1.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            results[i] = queue.poll().getKey();
        }
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,2}, 2)));
    }
}