/**
 * 38. 外观数列
 *
 * 给定一个正整数 n（1 ≤n≤ 30），输出外观数列的第 n 项。
 *
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 *
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 *
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 *
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 *
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 *
 * 示例1:
 * 输入: 1
 * 输出: "1"
 * 解释：这是一个基本样例。
 *
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 * 解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */

public class Solution {
    public String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuffer sb = new StringBuffer();
        // 拿到上一层的字符串，从上一层已经处理好的字符串开始进行这一层的处理
        String str = countAndSay(n - 1);
        int len = str.length();
        // 开始指针为0
        int start = 0;
        // 注意这从起始条件要和下面长度统一
        for (int i = 1; i < len + 1; i++) {
            // 字符串最后一位直接拼接，不需要更新start位
            if (i == len) {
                sb.append(i - start).append(str.charAt(start));
            }
            // 直到start位的字符串和i位的字符串不同，拼接并更新start位
            else if (str.charAt(i) != str.charAt(start) ) {
                // 先append数量，再append字符
                sb.append(i - start).append(str.charAt(start));
                // 更新start位
                start = i;
            }
        }
        return sb.toString();
    }
}
