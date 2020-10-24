/**
 * 64. 最小路径和
 *
 * 给定一个包含非负整数的 mxn网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 * 输入:
 * [
 *  [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */

public class Solution {
    /**
     * 使用动态规划的思想解答这个问题
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        //　遍历整个二维数组，将数组每个位置的值换为到达当前位置的最小路径和
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                // 如果当前位置在第一行，那么它的路径只能由它左边的位置到达
                else if (i == 0)
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                // 如果当前位置在第一列，那么它的位置只能由它上边的位置到达
                else if (j == 0)
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                // 其他情况既可以从上边位置到达，也可以从左边位置到达，取这两种方法的最小值即可
                else
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        // 此时终点位置的值即为到达的最小路径和，返回数组该位置的值即可
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
