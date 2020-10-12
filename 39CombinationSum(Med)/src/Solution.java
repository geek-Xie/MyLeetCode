/**
 * 39. 组合总和
 *
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 */

import java.util.*;

public class Solution {
    /**
     * 使用回溯法进行遍历搜索
     * @param candidates 操作的数组
     * @param target 目标值
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 存储结果的列表
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    /**
     * 回溯法，每一次都可以使用当前元素或者不使用当前元素
     * @param candidates 操作的数组
     * @param target 目标值
     * @param ans 存出结果的列表
     * @param combine 当前组合的列表
     * @param index 当前数组所在下标
     */
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int index) {
        // 如果已经将数组遍历完了，直接返回
        if (index == candidates.length) {
            return;
        }
        // 如果当前与目标值差值为0，即和已经等于目标值了，将当前组合添加到结果列表中后返回
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 选择1：不使用当前元素，跳到数组的下一个元素
        dfs(candidates, target, ans, combine, index + 1);
        // 选择2：使用当前元素
        if (target - candidates[index] >= 0) {
            // 将元素添加到当前的组合中去
            combine.add(candidates[index]);
            // 继续使用当前元素进行组合
            dfs(candidates, target - candidates[index], ans, combine, index);
            // 回溯：去掉最新添加的元素
            combine.remove(combine.size() - 1);
        }
    }
}
