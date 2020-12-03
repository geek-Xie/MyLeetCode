/**
 * 144. 二叉树的前序遍历
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
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
 *
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
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
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return res;
        preoder(root);
        return res;
    }

    /**
     * 常规的前序遍历的代码格式
     * @param root
     */
    private void preoder(TreeNode root) {
        res.add(root.val);

        if (root.left != null)
            preoder(root.left);
        if (root.right != null)
            preoder(root.right);
    }
}
