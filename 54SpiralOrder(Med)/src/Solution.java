/**
 * 54. 螺旋矩阵
 *
 * 给定一个包含m x n个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 使用模拟的方法进行数组的遍历输出，将数组分为若干层，首先输出最外层的元素，接着输出次外层。。。
     * 定义第k层是到最近边界距离为k的所有顶点
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return res;
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;

        // 对当前的层模拟遍历输出
        while (left <= right && top <= bottom) {
            for (int le = left; le <= right; le++)
                res.add(matrix[top][le]);
            for (int to = top + 1; to <= bottom; to++)
                res.add(matrix[to][right]);
            if (left < right && top < bottom) {
                for (int ri = right - 1; ri >= left; ri--)
                    res.add(matrix[bottom][ri]);
                for (int bo = bottom - 1; bo > top; bo--)
                    res.add(matrix[bo][left]);
            }

            // 改变边界到下一层
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
