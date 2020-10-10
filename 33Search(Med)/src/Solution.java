/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2])。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是O(logn) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 *
 * 示例2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Solution {
    public int search(int[] nums, int target) {
        // 如果数组是空的，直接返回-1
        if (nums.length == 0)
            return -1;

        // 存储结果的变量
        int index = -1;
        int len = nums.length;

        // 如果第一个值的大小就是目标值，直接返回
        if (nums[0] == target)
            return 0;

        // 如果第一个值小于目标值
        else if (nums[0] < target) {
            int i = 1;
            // 从头开始遍历
            while (i < len && nums[i] > nums[i - 1]) {
                if (nums[i] == target) {
                    index = i;
                    break;
                }
                i++;
            }
        }
        // 如果第一个值大于目标值
        else {
            if (nums[len - 1] == target)
                return len - 1;
            int i = len - 2;
            // 从尾部开始遍历查找
            while (i > 0 && nums[i] < nums[i + 1]) {
                if (nums[i] == target) {
                    index = i;
                    break;
                }
                i--;
            }
        }
        return index;
    }
}
