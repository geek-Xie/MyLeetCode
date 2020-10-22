/**
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数n，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */

public class Solution {
    /**
     * 解决方法与  54. 螺旋矩阵  中的方法一样，都是模拟出一层一层遍历的过程，详见  54. 螺旋矩阵 解答过程
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int curcum = 1;
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;

        while (left <= right && top <= bottom) {
            for (int le = left; le <= right; le++) {
                res[top][le] = curcum;
                curcum++;
            }
            for (int to = top + 1; to <= bottom; to++) {
                res[to][right] = curcum;
                curcum++;
            }
            if (left < right && top < bottom) {
                for (int ri = right - 1; ri >= left; ri--) {
                    res[bottom][ri] = curcum;
                    curcum++;
                }
                for (int bo = bottom - 1; bo > top; bo--) {
                    res[bo][left] = curcum;
                    curcum++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
