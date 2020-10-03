import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * 使用哈希表和回溯法来解决这个问题
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        // 如果输入的字符串是空的，则直接返回
        if (digits.length() == 0) {
            return combinations;
        }
        // 建立一个哈希表存储相应数字和字母组合之间的映射关系
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }


    /**
     * 回溯法
     * @param combinations 结果列表
     * @param phoneMap 数字组合和字母组合对应的哈希表映射
     * @param digits 输入的数字组合
     * @param index 当前下标
     * @param combination 当前的字母组合
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 如果当前已经遍历结束，则将当前的字母组合加入结果列表中
        if (index == digits.length()) {
            combinations.add(combination.toString());
        }
        else {
            // 取出当前下表下的数字
            char digit = digits.charAt(index);
            // 找到该数字对应的字母
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            // 进行字母的添加
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                // 下标往后移动一位
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                // 回溯，添加下一个位置的字母
                combination.deleteCharAt(index);
            }
        }
    }
}
