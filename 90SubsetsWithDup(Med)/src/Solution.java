/**
 * 90. 子集 II
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */

import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 存储结果的列表
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 使用回溯法解决问题
        backtrack(nums, 0, cur, res);
        return res;
    }

    /**
     * 回溯法
     * @param nums  待处理的数组
     * @param start 当前开始的下标
     * @param cur   存储当前的组合的列表
     * @param res   存储最终结果的列表
     */
    private void backtrack(int[] nums, int start, ArrayList<Integer> cur, List<List<Integer>> res) {
        // 先将当前的组合添加到最终结果的列表中
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            //和上个数字相等就跳过
            if (i > start && nums[i] == nums[i - 1])
                continue;

            cur.add(nums[i]);
            backtrack(nums, i + 1, cur, res);
            // 回溯
            cur.remove(cur.size() - 1);
        }
    }
}
