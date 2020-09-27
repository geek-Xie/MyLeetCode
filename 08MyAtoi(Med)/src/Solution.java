/**
 * 请你来实现一个atoi函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为[−231, 231− 1]。如果数值超过这个范围，请返回 INT_MAX (231− 1) 或INT_MIN (−231) 。
 *
 * 示例1:
 * 输入: "42"
 * 输出: 42
 *
 * 示例2:
 * 输入: "    -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * 示例3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 示例4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 *
 * 示例5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 */
public class Solution {
    public int myAtoi(String str) {
        // 如果当前的字符串是个空字符串，则直接返回0
        if (str.equals(""))
            return 0;

        char[] ch = str.toCharArray();
        // 用来存储处理过后的字符串
        StringBuffer sb = new StringBuffer();
        int start = 0;
        // 剔除开头的空格
        for (int i = 0; i < ch.length; i++){
            if (ch[i] == ' '){
                start++;
                continue;
            }
            if (ch[i] != ' ')
                break;
        }
        // 表示整个字符串都是空格，返回0
        if (start == ch.length)
            return 0;

        // 如果是除了'+'和'-'之外的其他非数字字符开头，直接返回0
        if (((int)ch[start] < 48 || (int)ch[start] > 57) && ch[start] != '-' && ch[start] != '+')
            return 0;

        // 如果开头是'+'或'-'，但是之后接着的不是数字字符，也返回0
        if ((ch[start] == '-' || ch[start] == '+') && (str.length() < 2 || ((int)ch[start + 1] < 48 || (int)ch[start + 1] > 57)))
            return 0;


        else {
            // 如果数字前有符号，则先添加符号
            if (ch[start] == '-' || ch[start] == '+'){
                sb.append(ch[start]);
                start++;
            }
            // 遍历完数字字符，直到出现第一个非数字字符停止
            while (start < ch.length && (int) ch[start] >= 48 && (int) ch[start] <= 57){
                sb.append(ch[start]);
                start++;
            }
        }

        // 将结果数字从字符串类型转化为整型输出
        try {
            // 如果转化出来的数字超出整型范围，捕获异常
            int res = Integer.valueOf(sb.toString());
        }
        // 对异常进行处理后，按照规则输出
        catch (NumberFormatException e){
            if (sb.charAt(0) == '-'){
                return Integer.MIN_VALUE;
            }
            else if (sb.charAt(0) != '-'){
                return Integer.MAX_VALUE;
            }
        }
        // 没有超出范围则正常转化为整型后输出
        int res = Integer.valueOf(sb.toString());

        return res;
    }
}
