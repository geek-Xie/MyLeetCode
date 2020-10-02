/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 */

import java.util.Arrays;

public class Solution {
    /**
     * 可以沿用之前查找三个数之和的方法的思路进行解答，进行一些小的变形即可
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        // 先对数组进行排序
        Arrays.sort(nums);
        // 数组长度
        int len = nums.length;
        // 当前最接近的和
        int best = 1000000;

        // 枚举 a
        for (int first = 0; first < len; ++first) {
            // 保证和上一次枚举的元素不相等
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int second = first + 1, third = len - 1;
            while (second < third) {
                // 当前的三个数的和
                int sum = nums[first] + nums[second] + nums[third];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int third0 = third - 1;
                    // 移动到下一个不相等的元素
                    while (second < third0 && nums[third0] == nums[third]) {
                        --third0;
                    }
                    third = third0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int second0 = second + 1;
                    // 移动到下一个不相等的元素
                    while (second0 < third && nums[second0] == nums[second]) {
                        ++second0;
                    }
                    second = second0;
                }
            }
        }
        return best;
    }
}
