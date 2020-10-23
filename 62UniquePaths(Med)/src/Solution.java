/**
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 * 示例1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 示例2:
 * 输入: m = 7, n = 3
 * 输出: 28
 */

public class Solution {
    // 定义一个存储走法数量的全局变量
    public static int result = 0;
    /**
     * 使用回溯法解决这个问题
     */
    public int uniquePaths(int m, int n) {
        // 判断是否走过
        boolean[][] marked = new boolean[m][n];
        // 回溯法
        backtrack(marked, m, n, 0, 0);
        return result;
    }

    private void backtrack(boolean[][] marked, int rows, int cols, int top, int left) {
        // 如果当前已经走到右下角的位置，则说明当前的走法成立，可行走法数量加1
        if (top == rows - 1 && left == cols - 1){
            result++;
        }
        else {
            // 如果此时能够往右走
            if (left + 1 < cols && !marked[top][left + 1]){
                // 将右边的位置标识为已经走过
                marked[top][left + 1] = true;
                backtrack(marked,rows,cols,top,left + 1);
                // 回溯
                marked[top][left + 1] = false;
            }
            // 如果此时可以往下走
            if (top + 1 < rows && !marked[top + 1][left]){
                // 将下面的位置标识为已经走过
                marked[top + 1][left] = true;
                backtrack(marked,rows,cols,top + 1,left);
                // 回溯
                marked[top + 1][left] = false;
            }
        }
    }
}
