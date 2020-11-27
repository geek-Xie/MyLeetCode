/**
 * 125. 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */

public class Solution {
    public boolean isPalindrome(String s) {
        // 如果字符串是空的，直接返回true
        if (s == null)
            return true;
        // 将字符串的大小写统一为小写
        char[] ch = s.toLowerCase().toCharArray();
        // 设置前后指针
        int first = 0;
        int last = ch.length - 1;
        while (first < last) {
            // 过滤掉除了字母和数字意外的字符
            if (ch[first] < '0' || ch[first] > 'z' || (ch[first] > '9' && ch[first] < 'A') || (ch[first] > 'Z' && ch[first] < 'a' || ch[first] == ' ')) {
                first++;
                continue;
            }
            if (ch[last] < '0' || ch[last] > 'z' || (ch[last] > '9' && ch[last] < 'A') || (ch[last] > 'Z' && ch[last] < 'a') || ch[last] == ' ') {
                last--;
                continue;
            }
            // 如果当前的字符一直，则继续遍历
            if (ch[first] == ch[last]) {
                first++;
                last--;
            }
            // 如果当前的字符不同，则返回false
            else if (ch[first] != ch[last])
                return false;
        }
        return true;
    }
}
