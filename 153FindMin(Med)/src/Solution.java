/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 *
 *
 * 示例 2：
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 *
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出：1
 */

public class Solution {
    public int findMin(int[] nums) {
        // 如果数组的长度是1，则直接返回这个元素
        if (nums.length == 1)
            return nums[0];
        int index = 0;
        // 找到数组中第一个比之前的元素小的元素，这就是数组中最小的元素
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                index = i;
                break;
            }
        }
        return nums[index];
    }
}
