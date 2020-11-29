/**
 * 131. 分割回文串
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 * 输入:"aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */

import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        // 如果长度是0， 则直接返回空的结果列表
        if (len == 0)
            return res;

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> path = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> path = new ArrayDeque<>();
        backtrack(s, 0, len, path, res);
        return res;
    }

    /**
     * @param s
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    private void backtrack(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
            // 不是的话，剪枝
            if (!checkPalindrome(s, start, i))
                continue;

            path.addLast(s.substring(start, i + 1));
            backtrack(s, i + 1, len, path, res);
            path.removeLast();
        }
    }

    /**
     * 判断是否是回文串
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划先把回文子串的结果记录在一个表格里
     * @param str
     * @param left  子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
        // 严格小于即可
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
