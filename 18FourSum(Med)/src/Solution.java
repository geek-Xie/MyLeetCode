/**
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * 解题思路与三数之和的思路一致，详见15ThreeSum，只是相对添加了一重循环
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0;first < len;first++){
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            for (int second = first + 1;second < len;second++){
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;

                int forth = len - 1;

                for (int third = second + 1;third < len;third++){
                    if (third > second + 1 && nums[third] == nums[third - 1])
                        continue;
                    while (forth > third && nums[first] + nums[second] + nums[third] + nums[forth] > target)
                        forth--;
                    if (third == forth)
                        break;
                    if (nums[first] + nums[second] + nums[third] + nums[forth] == target){
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[first]);
                        arr.add(nums[second]);
                        arr.add(nums[third]);
                        arr.add(nums[forth]);
                        res.add(arr);
                    }
                }
            }
        }
        return res;
    }
}
