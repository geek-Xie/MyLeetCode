/**
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 *
 * 示例2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */

public class Solution {
    /**
     * 解答过程就是模拟数字的加法笔试过程
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            // 如果不产生进位，则直接返回结果数组
            if (digits[i] != 0)
                return digits;
        }
        // 如果到最高位还有进位，则需要将数组拓展以为
        digits = new int[digits.length + 1];
        // 最高位进位后为1
        digits[0] = 1;
        return digits;
    }
}
