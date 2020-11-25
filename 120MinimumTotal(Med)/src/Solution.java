/**
 * 120. 三角形最小路径和
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 */

import java.util.List;

public class Solution {
    /**
     * 动态规划
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        // dp数组表示每个位置上的值表示走到该位置所需要的花费
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            // 每一行的第一列只能从上一行的第一列往下走
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            // 除了第一列和最后一列的位置，其他位置都可以从正上方往下走或者左上方往下走，取这两种情况的较小值，得到走到该位置的最小花费
            for (int j = 1; j < i; j++)
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            // 每一行的最后一个位置只能从左上方走到
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        // 遍历dp数组的最后一行，找到最小的值，就是自顶向下到达最后一行的最小花费
        int minTotal = dp[size - 1][0];
        for (int i = 1; i < size; i++) {
            minTotal = Math.min(minTotal, dp[size - 1][i]);
        }
        return minTotal;
    }
}
