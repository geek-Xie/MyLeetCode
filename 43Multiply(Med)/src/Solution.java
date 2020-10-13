/**
 * 43. 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 *
 * 示例2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 *
 * 说明
 * 1.num1和num2的长度小于110。
 * 2.num1 和num2 只包含数字0-9。
 * 3.num1 和num2均不以零开头，除非是数字 0 本身。
 * 4.不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

public class Solution {
    public String multiply(String num1, String num2) {
        // 如果num1或者num2中有一个是0，则直接返回 0 即可
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 记录num1和num2的长度
        int len1 = num1.length();
        int len2 = num2.length();
        // 存储结果的数组
        int[] ansArr = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            // 将字符串转化为相同数字的整型
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                // 存储相乘的结果
                ansArr[i + j + 1] = ansArr[i + j + 1] + (x * y);
            }
        }
        // 处理进位的情况
        for (int i = len1 + len2 - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] = ansArr[i] % 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;

        // 将结果数组转化为字符串
        StringBuffer ans = new StringBuffer();
        while (index < len1 + len2) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}
