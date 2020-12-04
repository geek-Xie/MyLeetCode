/**
 * 145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
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
    // 存储遍历结果的列表
    List<Integer> res = new ArrayList<>();

    /**
     * 常规的后序遍历代码格式
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return res;
        postorder(root);
        return res;
    }

    private void postorder(TreeNode root) {
        if (root.left != null)
            postorder(root.left);
        if (root.right != null)
            postorder(root.right);
        res.add(root.val);
    }
}
