/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 与nums数组相同的长度，用来记录相应位置的数字是否已经被填写过
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 存储最后结果的列表
        List<List<Integer>> ans = new ArrayList<>();
        // 存储当前结果的列表
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        // 对数组进行排序
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    /**
     * 回溯法
     * @param nums 选择的数组
     * @param ans 最终结果列表
     * @param index 当前结果填写的下标
     * @param perm 当前结果列表
     */
    public void backtrack(int[] nums, List<List<Integer>> ans, int index, List<Integer> perm) {
        // 如果已经将选择数组遍历结束，则将当前结果加入到最终结果的列表中
        if (index == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果该位置的数字被填写过
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            // 将当前的数字添加到当前结果中
            perm.add(nums[i]);
            // 并将当前的数字状态标为已使用
            vis[i] = true;
            // 递归下一个数字
            backtrack(nums, ans, index + 1, perm);
            // 回溯
            vis[i] = false;
            perm.remove(index);
        }
    }
}
