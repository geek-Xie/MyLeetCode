/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回[-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 *
 * 示例2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        // 如果数组是空的，直接返回
        if (len == 0)
            return new int[]{-1, -1};
        // 如果目标值比数组中最小的数值还小，直接返回
        if (target < nums[0])
            return new int[]{-1, -1};
        // 如果目标值比数组中最大的数值还大，直接返回
        if (target > nums[len - 1])
            return new int[]{-1, -1};

        // 前后指针同时进行遍历
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            if (nums[start] != target && nums[end] != target) {
                start++;
                end--;
                continue;
            }
            else if (nums[start] == target && nums[end] != target) {
                end--;
                continue;
            }
            else if (nums[start] != target && nums[end] == target) {
                start++;
                continue;
            }
            else
                break;
        }
        // 如果查找不到，直接返回
        if (start > end)
            return new int[]{-1, -1};

        return new int[]{start,end};
    }
}
