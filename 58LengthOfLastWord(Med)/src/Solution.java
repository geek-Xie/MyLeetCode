/**
 * 58. 最后一个单词的长度
 *
 * 给定一个仅包含大小写字母和空格' '的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        // 如果字符串是空的，则直接返回0
        if (s.length() == 0)
            return 0;
        char[] ch = s.toCharArray();
        int res = 0;
        int len = ch.length;
        int index = len - 1;
        // 将字符串末尾的空格去掉
        while (index >= 0 && ch[index] == ' ')
            index--;
        // 从后开始遍历字符串，知道遇到第一个空格，即最后一个单词遍历结束，统计字母的数量
        for (int i = index; i >= 0;i--){
            if (ch[i] == ' ')
                break;
            res++;
        }
        // 返回结果
        return res;
    }
}
