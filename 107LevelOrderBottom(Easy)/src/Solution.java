/**
 * 107. 二叉树的层次遍历 II
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    /**
     * 与 102. 二叉树的层序遍历 题目中的思路是一样的，只是因为要求从下到上输出，在最后将res列表进行一个翻转
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        if (root == null)
            return new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            List<TreeNode> tcur = new ArrayList<>();

            for (TreeNode t : queue)
                cur.add(t.val);
            res.add(cur);

            while (!queue.isEmpty())
                tcur.add(queue.poll());

            for (TreeNode t : tcur) {
                if (t.left != null)
                    queue.offer(t.left);
                if (t.right != null)
                    queue.offer(t.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
