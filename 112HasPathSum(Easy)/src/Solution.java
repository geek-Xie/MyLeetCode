/**
 * 112. 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 如果当前节点是空的，返回false
        if (root == null)
            return false;
        // 如果当前节点是叶子节点，则判断当前路径是否能满足和为sum的条件
        if (root.left == null && root.right == null)
            return sum == root.val;
        // 递归判断左右子树
        else
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
