/**
 * 79. 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */

public class Solution {
    public boolean exist(char[][] board, String word) {
        // 获得矩阵的行和列
        int rows = board.length, cols = board[0].length;
        // 标记数组，用来避免字母被重复使用
        boolean[][] visited = new boolean[rows][cols];
        // 遍历数组的每个位置作为起点，尝试找到单词组合
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 判断从当前位置出发是否有可能找到符合要求的单词字母组合
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int index) {
        // 如果当前字符不一致，则返回false
        if (board[i][j] != s.charAt(index))
            return false;
        // 如果当前已经遍历完了字符串，则返回true
        else if (index == s.length() - 1) {
            return true;
        }
        // 将当前位置标志为已经访问过
        visited[i][j] = true;
        // 共有四个前进的方向，上下左右
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            // 确定新位置的坐标
            int newi = i + dir[0], newj = j + dir[1];
            // 访问新的位置
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, index + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
