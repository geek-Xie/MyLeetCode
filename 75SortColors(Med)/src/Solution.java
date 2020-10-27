/**
 * 75. 颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public void sortColors(int[] nums) {
        // 使用map记录不同的颜色出现的对应的次数，使用TreeMap是为了顺便排序，方便之后的操作
        Map<Integer, Integer> map = new TreeMap();
        // 遍历数组，记录出现的次数
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            // 如果这个颜色之前没有记录，则新增记录
            if (!map.containsKey(k)) {
                map.put(k, 1);
            }
            // 如果这个颜色之前已经有记录了，则将出现的次数增加1
            else {
                int v = map.get(k);
                v++;
                map.remove(k);
                map.put(k, v);
            }
        }
        int index = 0;
        // 根据之前的记录重写数组
        for (int i = 0; i < 3; i++) {
            if (!map.containsKey(i))
                continue;
            int t = 0;
            while (t < map.get(i)) {
                nums[index] = i;
                index++;
                t++;
            }
        }
    }
}
