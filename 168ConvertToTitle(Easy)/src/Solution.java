/**
 * 168. Excel表列名称
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 *
 * 示例2:
 * 输入: 28
 * 输出: "AB"
 *
 * 示例3:
 * 输入: 701
 * 输出: "ZY"
 */

public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int c = columnNumber % 26;
            if(c == 0){
                c = 26;
                columnNumber -= 1;
            }
            sb.insert(0, (char) ('A' + c - 1));
            columnNumber /= 26;
        }
        return sb.toString();
    }
}
