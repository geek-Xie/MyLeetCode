/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 *
 * 示例2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 如果输入的数组是空的，则直接返回空
        if (strs.length == 0)
            return "";
        // 如果输入的数组只有1个元素，则直接返回这个元素
        if (strs.length == 1)
            return strs[0];
        // 数组的长度
        int len = strs.length;
        // 数组中最短的字符串的长度
        int minslen = Integer.MAX_VALUE;
        // 最长前缀的下标
        int index = -1;
        // 是否相同的标志
        boolean same = true;

        // 得到最短的字符串的长度
        for (int i = 0; i < len; i++) {
            int t = strs[i].length();
            minslen = Math.min(minslen, t);
        }

        // 如果数组中有空的字符串，那么没有最长前缀
        if (minslen == 0)
            return "";
            // 按顺序遍历每一个字符串，直到出现不一样的字符
        else {
            for (int i = 0; i < minslen; i++) {
                char ch = strs[0].charAt(i);
                for (int j = 0; j < len; j++) {
                    if (strs[j].charAt(i) != ch) {
                        index = i - 1;
                        same = false;
                        break;
                    }
                }
                // 最长前缀下标移动一位
                index++;
                if (!same) {
                    index--;
                    break;
                }
            }
        }
        // 根据得到的最长前缀的截止下标输出字符串
        StringBuffer sb = new StringBuffer();
        if (index == -1)
            return "";
        else {
            for (int i = 0; i <= index; i++) {
                sb.append(strs[0].charAt(i));
            }
        }
        return sb.toString();
    }
}
