/**
 * 49. 字母异位词分组
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 *
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 如果输入的数组是空的，则直接返回null
        if (strs.length == 0)
            return null;

        List<List<String>> res = new ArrayList<>();
        int index = 0;
        // 建立一个哈希映射存储当前字母组合和结果列表中所在位置
        Map<String, Integer> map = new HashMap<>();
        map.put(" ", -1);
        int len = strs.length;
        // 对字符串数组进行遍历
        for (int i = 0; i < len; i++) {
            String temp = strs[i];
            char[] ch = temp.toCharArray();
            // 转化为有序的字母组合
            Arrays.sort(ch);
            String s = new String(ch);
            // 如果当前映射中没有这种字母组合
            if (!map.containsKey(s)) {
                // 将当前的字母组合和应该所在的结果列表的下标添加到映射中
                map.put(s, index);
                // 创建一个新列表存储这种组合的单词
                List<String> list = new ArrayList<>();
                list.add(temp);
                res.add(list);
                index++;
            } else
                // 如果当前组合已经存在，则通过映射中的下标找到这个组合所在的列表将当前的单词添加到对应的列表中
                res.get(map.get(s)).add(temp);
        }
        return res;
    }
}
