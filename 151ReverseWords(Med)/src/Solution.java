/**
 * 151. 翻转字符串里的单词
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 示例 1：
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 *
 * 示例 2：
 * 输入：" hello world! "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 *
 * 示例 3：
 * 输入："a good  example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 示例 4：
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 *
 *
 * 示例 5：
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 */

public class Solution {
    public String reverseWords(String s) {
        // 首先将字符串转化为字符数组
        char[] ch = s.toCharArray();
        int start = 0;
        // 剔除掉开头的空格
        while (ch[start] == ' ')
            start++;
        StringBuffer sb = new StringBuffer();
        // 处理字符串中间的空格
        for (int i = start; i < ch.length; i++) {
            if (ch[i] != ' ')
                sb.append(ch[i]);
            else if (ch[i] == ' ' && ch[i - 1] != ' ')
                sb.append(" ");
        }
        // 得到经过处理的正向排列的字符串
        String str = sb.toString();
        String[] strarr = str.split(" ");
        // 结果字符串
        String res = "";
        // 从后往前遍历字符串数组，并在除了最后一个元素之后的地方加入空格
        for (int i = strarr.length - 1; i > 0; i--) {
            res += strarr[i];
            res += " ";
        }
        // 添加最后一个元素
        res += strarr[0];

        return res;
    }
}
