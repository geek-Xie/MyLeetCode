/**
 * 110. 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 */

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
    public boolean isBalanced(TreeNode root) {
        // 如果当前节点是空的
        if (root == null)
            // 空树也是平衡二叉树
            return true;
        else
            // 判断左右子树的高度是否相差小于1，并且左右子树也同时满足为平衡二叉树
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

    }

    /**
     * 计算当前节点的高度
     * @param root 当前节点
     * @return
     */
    private int height(TreeNode root) {
        // 空节点高度为 0
        if (root == null)
            return 0;
        else
            // 当前节点的高度为其左右子树的高度较大值 + 1
            return Math.max(height(root.left), height(root.right)) + 1;
    }
}
