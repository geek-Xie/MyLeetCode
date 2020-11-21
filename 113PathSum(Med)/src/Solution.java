/**
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    // 存储最后的结果
    public List<List<Integer>> res = new ArrayList<>();
    // 存储中间结果
    public Deque<Integer> cur = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        build(root, sum);
        return res;
    }

    /**
     * @param root 当前节点
     * @param sum 和
     */
    private void build(TreeNode root, int sum) {
        // 如果当前节点是空的，直接返回
        if (root == null)
            return;
        // 添加到当前序列
        cur.offerLast(root.val);
        sum -= root.val;
        // 如果此时刚好满足和，且已经到达叶子结点，则将当前序列添加到结果序列中
        if (sum == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(cur));

        // 遍历左右子树
        build(root.left, sum);
        build(root.right, sum);
        // 回溯
        cur.pollLast();
    }
}
