/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class Solution {
    /**
     * 使用一遍扫描解决问题
     * 首先我们清楚，对于一个降序排列的数组，已经没有能比它更大的数字组合，因此我们在拿到第一个当前位置比后一个位置数字更小的数字的时候，
     * 只能从这个数组的右边的降序序列中选择出第一个比它大的数字和它进行交换，即比它大中最小的数字。
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // 从数组的尾部开始进行扫描
        int i = nums.length - 2;
        // 直到找到第一个前一位小于后一位数字的位置
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 如果还没有到头，则从右边的降序序列中找到第一个比i大的数字
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 和i进行交换
            swap(nums, i, j);
        }
        // 将i后面的序列从降序变成升序，达到最小的要求
        reverse(nums, i + 1);
    }

    /**
     * 将数组进行反转的函数
     * @param nums 进行反转的数组
     * @param start 开始反转的位置
     */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    /**
     * 两值交换的函数
     * @param nums 数所在的数组
     * @param i 第一个进行交换的数
     * @param j 第二个进行交换的数
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
