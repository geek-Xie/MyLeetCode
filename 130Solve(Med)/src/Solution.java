/**
 * 130. 被围绕的区域
 *
 * 给定一个二维的矩阵，包含'X'和'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。
 *
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */

public class Solution {
    // 字符数组的行和列
    int rows, cols;

    public void solve(char[][] board) {
        rows = board.length;
        if (rows == 0)
            return;
        cols = board[0].length;
        // 对第一列和最后一列进行标记
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }
        // 对第一行和最后一行进行标记
        for (int i = 1; i < cols - 1; i++) {
            dfs(board, 0, i);
            dfs(board, rows - 1, i);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果遍历到的是与边界的'O'相连的'O'，此时他们被标记为'A'，则还原为'O'
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
                // 如果遍历到的是被包围的'O'，则将他们变为'X'
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 用递归的方法，从数组的四边的'O'出发，查找与这些'O'相连接的'O'，这些'O'即为未被'X'包围的'O'，并把他们标记为'A'
     * @param board
     * @param row
     * @param col
     */
    private void dfs(char[][] board, int row, int col) {
        // 如果超出了数组的边界或者当前的元素不是'O'，则返回
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O')
            return;

        board[row][col] = 'A';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
