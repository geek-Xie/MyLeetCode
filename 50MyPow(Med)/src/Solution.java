/**
 * 50. Pow(x, n)
 *
 * 实现pow(x, n)，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 *
 * 示例2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 *
 * 示例3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 说明:
 * -100.0 <x< 100.0
 * n是 32 位有符号整数，其数值范围是[−231,231− 1] 。
 */

public class Solution {
    /**
     * 使用迭代的方法完成上解决问题
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        // 拿到指数部分
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }


    public double quickMul(double x, long N) {
        double res = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                res *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return res;
    }
}
