/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入:n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 当前的组合
    List<Integer> curcom = new ArrayList<>();
    // 结果集合
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (curcom.size() + (n - cur + 1) < k)
            return;

        // 如果当期的组合已经达到长度要求，则加入到结果集合中去
        if (curcom.size() == k) {
            res.add(new ArrayList<>(curcom));
            return;
        }

        // 考虑选择当前位置
        curcom.add(cur);
        dfs(cur + 1, n, k);
        // 回溯，不选择当前位置的元素
        curcom.remove(curcom.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }
}
