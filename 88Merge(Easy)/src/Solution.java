/**
 * 88. 合并两个有序数组
 *
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * 说明：
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
 *
 * 示例：
 *
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出：[1,2,2,3,5,6]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 因为两个数组是有序的，因此直接合并两个有序数组即可，利用一个list先存储中间结果，再把最后的结果覆盖到nums1上面即可
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        List<Integer> list = new ArrayList<>();

        int index1 = 0;
        int index2 = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] <= nums2[index2]) {
                list.add(nums1[index1]);
                index1++;
            } else {
                list.add(nums2[index2]);
                index2++;
            }
        }

        if (index1 == m) {
            while (index2 < n) {
                list.add(nums2[index2]);
                index2++;
            }
        } else if (index2 == n) {
            while (index1 < m) {
                list.add(nums1[index1]);
                index1++;
            }
        }
        for (int i = 0; i < len; i++)
            nums1[i] = list.get(i);
    }
}
