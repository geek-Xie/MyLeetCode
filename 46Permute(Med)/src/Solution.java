/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * 使用回溯法解决这个问题
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        // 存储最终结果的列表
        List<List<Integer>> res = new ArrayList<>();

        // 存储当前结果的列表
        List<Integer> output = new ArrayList<>();
        // 先将所有的数添加到当前的结果数组中去，再在回溯法中进行各种交换获取不同的排列情况
        for (int num : nums) {
            output.add(num);
        }

        int len = nums.length;
        // 回溯法
        backtrack(len, output, res, 0);
        return res;
    }

    /**
     * 回溯法求全排列，我们可以将数组以first指针为界限，分为左边的已填写好的部分和右边的未填写的部分
     * @param len 排列数字的长度
     * @param output 当前的排列情况
     * @param res 存储结果的列表
     * @param first 当前的数字位置
     */
    public void backtrack(int len, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == len) {
            // 将当前的结果加入到最终结果列表中
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < len; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(len, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
