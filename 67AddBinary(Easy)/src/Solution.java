/**
 * 67. 二进制求和
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字1和0。
 *
 * 示例1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 *
 * 示例2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */

public class Solution {
    /**
     * 模拟竖式计算解答问题
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        // 存储结果的字符串
        StringBuffer res = new StringBuffer();

        // 取两个字符串的最大长度
        int len = Math.max(a.length(), b.length());
        // 进位标志
        int carry = 0;

        // 对竖式计算的模拟过程
        for (int i = 0; i < len; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            res.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            res.append('1');
        }
        // 结果进行转置
        res.reverse();

        return res.toString();
    }
}
