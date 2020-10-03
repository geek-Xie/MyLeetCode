/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */

import java.util.Stack;

public class Solution {
    /**
     * 借助数据结构--栈，来实现对括号合理性的判断
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // 如果输入的括号序列是空的，则认为是有效字符串
        if (s.length() == 0)
            return true;
        Stack stack = new Stack();
        char[] chars = s.toCharArray();

        for (int i = 0;i < chars.length;i++){
            // 如果当前是左括号，则直接入栈
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[')
                stack.push(chars[i]);
            // 如果当前是右括号且栈为空，则直接入栈
            else if ((chars[i] == ')' || chars[i] == '}' || chars[i] == ']') && stack.isEmpty())
                stack.push(chars[i]);
            // 如果当前是右括号且栈不为空，则判断当前栈顶的括号是否是当前括号所对应的左括号，如果是则弹出栈定元素，如果不是则该括号序列是无效的
            else {
                if (chars[i] == ')'){
                    if (stack.peek().equals('(')){
                        stack.pop();
                        continue;
                    }
                }
                else if (chars[i] == ']'){
                    if (stack.peek().equals('[')){
                        stack.pop();
                        continue;
                    }
                }
                else if (chars[i] == '}'){
                    if (stack.peek().equals('{')){
                        stack.pop();
                        continue;
                    }
                }
                return false;
            }
        }
        // 如果最后栈不为空，序列也为无效序列
        if (!stack.isEmpty())
            return false;
        return true;
    }
}
