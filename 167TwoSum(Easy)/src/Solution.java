/**
 * 167. 两数之和 II - 输入有序数组
 *
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 *
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 */


public class Solution {
    // 使用前后指针的方法进行判断
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length - 1;
        int[] res = new int[2];

        // 保证前后指针的位置
        while (first < last) {
            // 如果当前指向的两个数刚好等于target，则直接将坐标添加到结果数组中
            if (numbers[first] + numbers[last] == target) {
                res[0] = first + 1;
                res[1] = last + 1;
                break;
            }
            // 如果当前的和大于target，则右指针往前移动
            else if (numbers[first] + numbers[last] > target) {
                last--;
            }
            // 如果当前的和小于target，则左指针往后移动，且将右指针重新置为最后一个数
            else if (numbers[first] + numbers[last] < target) {
                first++;
                last = numbers.length - 1;
            }
        }
        return res;
    }

}
