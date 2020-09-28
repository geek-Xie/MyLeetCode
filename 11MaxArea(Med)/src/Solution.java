/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 *
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class Solution {
    /**
     * 使用双指针的方法确定最大值，即现在数组的最开始与最后设定两个指针，然后每次算出当前乘积之后移动指针，
     * 指针移动的规则是移动当前值较小的位置上的指针，因为我们要取的是成绩的最大值，即两个值中的较小值与两个值之间距离的成绩，因此为了求较大值肯定是移动较小的那个值
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int len = height.length;
        // 左指针
        int i = 0;
        // 右指针
        int j = len - 1;
        // 结果
        int res = 0;

        while (i < j){
            // 计算出当前情况下的成绩
            int temp = Math.min(height[i],height[j]) * (j-i);
            // 存储较大的那一个
            res = Math.max(res,temp);
            // 然后进行指针的移动
            if (height[i] <= height[j])
                i++;
            else if (height[i] > height[j])
                j--;
        }
        return res;
    }
}
