/**
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 存储遍历结果的列表
        List<Integer> res = new ArrayList<>();
        // 使用深度优先搜索进行中序遍历
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }
}
