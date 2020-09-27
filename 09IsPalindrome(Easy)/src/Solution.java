/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {
    public boolean isPalindrome(int x) {
        // 如果证书前面有负号，则一定不是回文数
        if (x < 0)
            return false;
        boolean isPallindrome = true;
        String str = String.valueOf(x);
        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length;i++){
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        int i = 0;
        int j = arr.length - 1;

        while (i < j){
            if (arr[i] == arr[j]){
                i++;
                j--;
            }
            else {
                isPallindrome = false;
                break;
            }
        }
        return isPallindrome;
    }
}
