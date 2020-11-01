/**
 * 81. 搜索旋转排序数组 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回true，否则返回false。
 *
 * 示例1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 *
 *
 * 示例2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */


public class Solution {
    public boolean search(int[] nums, int target) {
        // 如果数组是空的，则直接返回false
        if (nums.length == 0)
            return false;
        int len = nums.length;
        // 用来记录原排序数组的开头元素的位置，即第一个比前一个元素数值小的元素的位置
        int index = 1;
        // 找到第一个比前一个元素数值小的元素的位置
        while (index < len) {
            if (nums[index] < nums[index - 1])
                break;
            index++;
        }

        // 分类进行搜索
        if (nums[0] > target) {
            for (int i = index; i < len; i++) {
                if (nums[i] == target)
                    return true;
            }
        } else if (nums[0] < target) {
            for (int i = 0; i < index; i++) {
                if (nums[i] == target)
                    return true;
            }
        } else
            return true;
        return false;
    }
}
