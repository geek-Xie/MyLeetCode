/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int len = nums.length;
        // 使用一个map来存储数组中对应的元素与其出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : nums) {
            // 如果这个元素之前没有出现过，则创建一个新的键值对
            if (!map.containsKey(temp))
                map.put(temp, 1);
            // 如果这个元素之前已经出现过了，直接次数+1
            else {
                int times = map.get(temp) + 1;
                map.put(temp, times);
            }
        }
        // 遍历Map， 找到出现次数大于数组长度一半的元素
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > len / 2) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }
}
