/**
 * 63. 不同路径 II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例1:
 * 输入:
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */

public class Solution {
    /**
     * 该题目的解题思路与  62. 不同路径  完全一致，可以参考前题的解题思路
     */
    public static int result;
    public  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        backtrack(obstacleGrid,rows,cols,0,0);

        return result;
    }

    private  void backtrack(int[][] obstacleGrid, int rows, int cols, int top, int left) {
        // 如果当前已经走到右下角的位置，则说明当前的走法成立，可行走法数量加1
        if (top == rows - 1 && left == cols - 1){
            result++;
        }
        else {
            // 如果此时能够往右走
            if (left + 1 < cols && obstacleGrid[top][left + 1] != 1){
                // 将右边的位置标识为已经走过
                obstacleGrid[top][left + 1] = 1;
                backtrack(obstacleGrid,rows,cols,top,left + 1);
                // 回溯
                obstacleGrid[top][left + 1] = 0;
            }
            // 如果此时可以往下走
            if (top + 1 < rows && obstacleGrid[top + 1][left] != 1){
                // 将下面的位置标识为已经走过
                obstacleGrid[top + 1][left] = 1;
                backtrack(obstacleGrid,rows,cols,top + 1,left);
                // 回溯
                obstacleGrid[top + 1][left] = 0;
            }
        }
    }
}
