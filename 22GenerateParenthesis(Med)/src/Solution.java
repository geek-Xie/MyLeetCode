/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 使用回溯法的思想解答这个问题
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        // 存储最终结果的列表
        List<String> combinations = new ArrayList<String>();
        // 执行获得最终所有组合序列结果的方法，并存储在结果列表中
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    /**
     * 获取所有可能的括号组合
     * @param current 当前的组合
     * @param pos 当前位置
     * @param result 存储最后结果的列表
     */
    public void generateAll(char[] current, int pos, List<String> result) {
        // 如果当前已经遍历完一种组合
        if (pos == current.length) {
            // 如果当前的组合是合法序列
            if (valid(current)) {
                // 则添加到最终的结果列表之中
                result.add(new String(current));
            }
        }
        // 如果还没有遍历完毕，则遍历所有可能的左右括号组合，再去判断是否合法
        else {
            // 先添加左括号
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            // 再添加右括号
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    /**
     * 判断当前的组合是否是合法的括号序列
     * @param current 当前组合
     * @return
     */
    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}