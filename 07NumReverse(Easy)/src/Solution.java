/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */

public class Solution {
    /**
     * 题目难度不大，唯一需要注意的就是检查是否溢出的条件
     * @param x
     * @return
     */
    public int reverse(int x) {
        // 存储结果
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 检查溢出
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            // 检查溢出
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            rev = rev * 10 + pop;
        }
        return rev;
    }
}
