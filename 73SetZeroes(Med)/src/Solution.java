/**
 * 73. 矩阵置零
 *
 * 给定一个m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例1:
 * 输入:
 * [
 *  [1,1,1],
 *  [1,0,1],
 *  [1,1,1]
 * ]
 * 输出:
 * [
 *  [1,0,1],
 *  [0,0,0],
 *  [1,0,1]
 * ]
 *
 *
 * 示例2:
 * 输入:
 * [
 *  [0,1,2,0],
 *  [3,4,5,2],
 *  [1,3,1,5]
 * ]
 * 输出:
 * [
 *  [0,0,0,0],
 *  [0,4,5,0],
 *  [0,3,1,0]
 * ]
 */


import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        // 利用集合来记录应该置零的行和列，因为集合不重复的性质，不会存储重复的数据
        Set<Integer> zerorows = new HashSet<>();
        Set<Integer> zerocols = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 遍历原数组，记录应该被置零的行和列
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zerorows.add(i);
                    zerocols.add(j);
                }
            }
        for (int i : zerorows)
            // 将对应的行置零
            deleterows(matrix, i);
        for (int j : zerocols)
            // 将赌赢的列置零
            deletecols(matrix, j);
    }

    /**
     * 将数组的给定行置零的方法
     * @param matrix 目标数组
     * @param i 给定需要置零的行
     */
    private void deleterows(int[][] matrix, int i) {
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            matrix[i][j] = 0;
        }
    }

    /**
     * 将数组的给定列置零的方法
     * @param matrix 目标数组
     * @param j 给定需要置零的列
     */
    private void deletecols(int[][] matrix, int j) {
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            matrix[i][j] = 0;
        }
    }
}
