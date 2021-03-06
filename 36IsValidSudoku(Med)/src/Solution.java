/**
 * 36. 有效的数独
 *
 *判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 *
 * 示例1:
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 *
 * 示例2:
 * 输入:
 * [
 *  ["8","3",".",".","7",".",".",".","."],
 *  ["6",".",".","1","9","5",".",".","."],
 *  [".","9","8",".",".",".",".","6","."],
 *  ["8",".",".",".","6",".",".",".","3"],
 *  ["4",".",".","8",".","3",".",".","1"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".","6",".",".",".",".","2","8","."],
 *  [".",".",".","4","1","9",".",".","5"],
 *  [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 */

import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 数据的初始化
        // 存储每一行出现的情况
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        // 存储每一列出现的情况
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        // 存储每一个小宫格出现的情况
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // 数独的验证过程
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 取到当前位置的字符
                char num = board[i][j];
                // 如果当前位置不是空格
                if (num != '.') {
                    int n = num;
                    // 计算当前位置处于第几个小宫格
                    int box_index = (i / 3) * 3 + j / 3;

                    // 加入当前行所在的Map数组，并统计当前行出现的次数
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    // 加入当前列所在的Map数组，并统计当前列出现的次数
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    // 加入当前宫格所在的Map数组，并统计当前宫格出现的次数
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // 如果有次数大于1的位置出现，则证明当前的数独是不符合规则的，无效的
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
