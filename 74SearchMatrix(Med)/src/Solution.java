/**
 * 74. 搜索二维矩阵
 *
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * 输出：false
 *
 *
 * 示例 3：
 * 输入：matrix = [], target = 0
 * 输出：false
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 如果输入的矩阵的行或者列为0，则直接返回false
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;

        // 根据所给的矩阵的性质，我们先找到target有可能存在的行，并保存下来
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] > target)
                break;
            row++;
        }
        if (row == 0)
            return false;

        // 直接在target有可能出现的行中进行遍历搜索即可
        for (int j = 0; j < cols; j++) {
            // 如果找到了，则直接返回true
            if (matrix[row - 1][j] == target)
                return true;
        }
        return false;
    }
}
