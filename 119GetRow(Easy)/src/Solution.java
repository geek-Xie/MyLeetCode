/**
 * 119. 杨辉三角 II
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++)
            res.add(new ArrayList<Integer>());

        // 按照杨辉三角的特点进行构建
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j < i + 1; j++) {
                // 每一行的第一个和最后一个元素都是1
                if (j == 0 || j == i)
                    res.get(i).add(1);
                // 其余的元素都是前一行的头顶两个元素相加的和
                else
                    res.get(i).add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
        }
        // 返回所查询的行的列表
        return res.get(rowIndex);
    }
}
