package io.github.CookedFox.leetcode._923;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Author chenyuxin
 * @Date 2022/4/10 11:10
 * @Email cyx0402@yeah.net
 * @Version v1
 *
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 * As the answer can be very large, return it modulo 109 + 7.
 * Constraints:
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 **/
public class Solution {
    public int threeSumMulti(int[] arr, int target) {
        // 数组 Hash
        long[] counts = new long[101];
        Arrays.stream(arr).forEach(e -> {
            counts[e]++;
        });
        long result = 0;
        for (int i = 0; i < counts.length ; i++) {
            if (counts[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < counts.length; j++) {
                if (counts[j] == 0) {
                    continue;
                }
                int tmp = target - i - j;
                // condition 1: i < j < tmp
                if (tmp > j && tmp <= 100 && counts[tmp] > 0) {
                    result += counts[i] * counts[j] * counts[tmp];
                }
            }
            // condition 2: i i tmp
            if (counts[i] >= 2) {
                int tmp = target - i * 2;
                if (tmp >= 0 && tmp != i && tmp <= 100 && counts[tmp] > 0) {
                    result += counts[i] * (counts[i] - 1)/2 * counts[tmp];
                }
            }
        }
        // condition 3: target/3 target/3 target/3
        if (target%3 == 0 && counts[target / 3] >= 3) {
            result += counts[target/3] * (counts[target/3] - 1)  * (counts[target/3] - 2) / 6;
        }
        return (int)(result % (1e9+7));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
        solution.threeSumMulti(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0}, 0)
        );
    }
}
