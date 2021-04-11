/**
 * 166. 分数到小数
 * <p>
 * 给定两个整数，分别表示分数的分子numerator 和分母 denominator，以 字符串形式返回小数 。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 如果存在多个答案，只需返回 任意一个 。
 * <p>
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * <p>
 * 示例 1：
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * <p>
 * 示例 2：
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * <p>
 * 示例 3：
 * 输入：numerator = 2, denominator = 3
 * 输出："0.(6)"
 * <p>
 * 示例 4：
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * <p>
 * 示例 5：
 * 输入：numerator = 1, denominator = 5
 * 输出："0.2"
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 如果分子是 0，则直接输出结果为 0
        if (numerator == 0)
            return "0";
        StringBuilder fraction = new StringBuilder();
        // 如果分子或者分母其中只有一个是负数， 则添加一个负号
        if (numerator < 0 ^ denominator < 0)
            fraction.append("-");

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        // 模拟除法计算过程
        fraction.append(String.valueOf(dividend / divisor));
        // 计算余数
        long remainder = dividend % divisor;
        // 如果当前余数是0，则证明已经整除，直接返回结果
        if (remainder == 0)
            return fraction.toString();
        // 接下来计算小数点后的数字
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
