/**
 * 129. 求根到叶子节点数字之和
 *
 * 给定一个二叉树，它的每个结点都存放一个0-9的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 *
 * 示例 2:
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        // 如果节点是空的则直接返回 0
        if (root == null)
            return 0;
        // 存储每一个路径的总和的字符串
        List<String> list = new ArrayList<>();
        // 存储每一个路径的字符串生成过程的中间结果
        StringBuffer sb = new StringBuffer();

        // 获得所有路径的总和的字符串
        backtrace(root, list, sb);
        // 计算和
        int sum = 0;
        for (String s : list)
            sum += Integer.parseInt(s);
        return sum;
    }

    private void backtrace(TreeNode root, List<String> list, StringBuffer sb) {
        // 将当前的数字加入当前路径的字符串中
        sb.append(root.val);
        // 如果到了叶子结点上，则将当前的组合添加到最终结果的列表中
        if (root.left == null && root.right == null) {
            list.add(sb.toString());
            return;
        }
        // 遍历当前节点的左节点
        if (root.left != null) {
            backtrace(root.left, list, sb);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
        }
        // 遍历当前节点的右节点
        if (root.right != null) {
            backtrace(root.right, list, sb);
            // 回溯
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
