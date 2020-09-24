import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 *
 * 示例1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 *
 * 示例2:
 * 输入: s = "LEETCODEISHIRING", numRows =4
 * 输出:"LDREOEIIECIHNTSG"
 *
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */

public class Solution {
    /**
     * 通过题目的意思，其实和Z字形的排列没有什么关系，我们可以摒弃掉所谓的空间上的特点对字符串进行操作
     * @param s 待处理的字符串
     * @param numRows 规定的行的数量
     * @return
     */
    public String convert(String s, int numRows) {

        // 如果要求输出的只有1行，则直接返回字符串即可
        if (numRows == 1)
            return s;

        List<StringBuilder> rows = new ArrayList<>();

        // 先按照给定的条件创建出所需要的行数
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        // 当前所在的行
        int curRow = 0;
        // 设置一个判断当前向上或向下移动的标志位
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // 如果当前行在第一行，则一定往下走；如果当前行在最后一行，则一定往上走
            if (curRow == 0 || curRow == numRows - 1)
                goingDown = !goingDown;
            // 如果往下的标志位是true，则当前行往下移动；如果往下的标志位是false，则当前行往上移动
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows)
            ret.append(row);

        return ret.toString();
    }
}
