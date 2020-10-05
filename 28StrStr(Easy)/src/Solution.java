/**
 * 实现strStr()函数。
 *
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */

public class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = needle.length();
        int len2 = haystack.length();

        for (int start = 0; start < len2 - len1 + 1; start++) {
            // 如果haystack中存在一个和needle一样的字串，则返回当前开始的下标
            if (haystack.substring(start, start + len1).equals(needle)) {
                return start;
            }
        }
        // 如果找不到存在的字串，则返回-1
        return -1;
    }
}
