/**
 * 111. 二叉树的最小深度
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
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
    public int minDepth(TreeNode root) {
        // 如果当前节点不存在，返回深度为0
        if (root == null)
            return 0;
        // 如果当前节点没有左右子节点了，返回深度为1
        if (root.left == null && root.right == null)
            return 1;

        // 记录当前的最小深度
        int min_depth = Integer.MAX_VALUE;
        // 计算当前节点的左子树的最小深度，并与当前的最小深度比较，取较小值
        if (root.left != null)
            min_depth = Math.min(minDepth(root.left), min_depth);
        // 计算当前节点的右子树的最小深度，并与当前的最小深度比较，取较小值
        if (root.right != null)
            min_depth = Math.min(minDepth(root.right), min_depth);

        return min_depth + 1;
    }
}
