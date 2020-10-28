/**
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> curcom = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<>(curcom));
            return;
        }
        // 选择添加当前的元素
        curcom.add(nums[cur]);
        dfs(cur + 1, nums);
        // 不添加当前的元素
        curcom.remove(curcom.size() - 1);
        dfs(cur + 1, nums);
    }
}
