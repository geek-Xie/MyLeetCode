/**
 * 71. 简化路径
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 示例 1：
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 示例 2：
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *
 * 示例 3：
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *
 * 示例 4：
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 *
 * 示例 5：
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 *
 * 示例 6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 */

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 首先将字符串以 “/” 分隔存储到新的字符数组 str 中
        String[] str = path.split("/");
        for (String s : str) {
            // 如果访问到的是 “..” 则说明要返回上一级,要将当前元素出栈
            if (s.equals("..") ) {
                // 还需判断栈是否为空,否则会报错
                if (!stack.isEmpty() ) {
                    stack.pop();
                }
            }
            // 如果数组非空并且当前元素不是 “.” (排除两个"/"相邻的情况) ，说明当前元素是路径信息，要入栈
            else if (!s.equals("") && !s.equals(".")) {
                stack.push(s);
            }
        }
        // 如果栈内没有元素说明没有路径信息，返回 “/” 即可
        if (stack.isEmpty()) {
            return "/";
        }
        // 这里用到 StringBuilder 操作字符串，效率高
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            // 这里从栈底开始拿元素
            ans.append( "/" + stack.get(i) );
        }
        // 返回字符串结果
        return ans.toString();
    }
}
