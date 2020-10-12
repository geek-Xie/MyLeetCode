/**
 * 40. 组合总和 II
 *
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例1:
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 示例2:
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 所求解集为:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 */
import java.util.*;

public class Solution {
    // 统计是否出现重复元素的数组，长度为candidates数组中不同数字的个数，对于数组中的第pos个元素，它的值是freq[pos][0]，他出现的次数是freq[pos][1]
    List<int[]> freq = new ArrayList<>();
    // 存储结果的列表
    List<List<Integer>> ans = new ArrayList<>();
    // 存储当前组合的列表
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 首先将数组排序
        Arrays.sort(candidates);
        // 初始化freq
        for (int num : candidates) {
            int size = freq.size();
            // 如果当前的列表中没有当前你的数组元素，则将他添加到列表中并且出现次数赋值为1
            if (freq.isEmpty() || num != freq.get(size - 1)[0])
                freq.add(new int[]{num, 1});
            // 如果当前元素已经存在于列表中，则将它的出现次数加1
            else
                freq.get(size - 1)[1]++;
        }
        dfs(0, target);
        return ans;
    }

    /**
     * 回溯算法，同样是有两种选择：选择当前元素或者不选择当前元素
     * @param pos 当前遍历到的数组的下标
     * @param rest target剩余的值
     */
    public void dfs(int pos, int rest) {
        // 如果当前的剩余值是0，即证明和已经达到target的值，则将当前组合加入到结果列表中并返回
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }

        // 方案1：不选择当前元素
        dfs(pos + 1, rest);

        // 方案2：选择当前元素
        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; i++) {
            // 将当前的数字元素添加到组合中去，并移动到下一个数字元素处
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; i++) {
            // 回溯，移除之前添加的元素
            sequence.remove(sequence.size() - 1);
        }
    }
}
