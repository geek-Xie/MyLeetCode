/**
 * 172. 阶乘后的零
 *
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释:3! = 6, 尾数中没有零。
 *
 * 示例2:
 * 输入: 5
 * 输出: 1
 * 解释:5! = 120, 尾数中有 1 个零.
 *
 */

public class Solution {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }
}
