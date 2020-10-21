/**
 * 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间
 */

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // 如果给定的数组是空的
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 对二维数组按照第一个数字进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        // 存储结果的列表
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // 取出当前数组的前后两个数字
            int L = intervals[i][0], R = intervals[i][1];
            // 如果当前结果是空的或者当前数组的左边数字大于前一个数组的右边数字，即并没有覆盖的期间，则单独加入到结果列表中
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                // 如果当前数组的左边小于之前的右边，那么就要取当前数组和之前数组的右边的数比较，较大的作为新的右边
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        // 将列表转化为二维数组输出
        return merged.toArray(new int[merged.size()][]);
    }
}
