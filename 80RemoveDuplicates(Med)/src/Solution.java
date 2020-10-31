/**
 * 80. 删除排序数组中的重复项 II
 *
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 * 示例 1：
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。。
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        // 当前下标
        int index = 1;
        // 当前元素出现次数
        int count = 1;
        int len = nums.length;
        while (index < len) {
            if (nums[index] == nums[index - 1]) {
                count++;
                if (count > 2) {
                    remElement(nums, index);
                    index--;
                    len--;
                }
            }
            // 如果当前出现的数字和之前的不一样了，则把计数器重置为1
            else
                count = 1;
            // 下标向后移动
            index++;
        }
        // 返回数组长度
        return len;
    }

    /**
     * 用来移除数组中相应位置元素的函数
     * @param arr 目标数组
     * @param index 移除元素的下标
     * @return
     */
    private int[] remElement(int[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++)
            arr[i - 1] = arr[i];

        return arr;
    }
}
