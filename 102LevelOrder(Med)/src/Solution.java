/**
 * 102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
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
    /**
     * 使用广度优先搜索，在此基础上加上对层数的记录即可
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 记录最终结果的列表
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        if(root.left == null && root.right == null){
            List<Integer> t = new ArrayList<>();
            t.add(root.val);
            res.add(t);
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 广度优先搜索的过程
        while (!queue.isEmpty()){
            // 这是用来记录当前行的节点的两个列表
            List<TreeNode> tcur = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();

            // 当前队列中的节点就是同一行的节点，拿出来添加到列表当中
            while (!queue.isEmpty())
                tcur.add(queue.poll());
            for (TreeNode t : tcur)
                cur.add(t.val);
            res.add(cur);

            // 将当前行的节点的所有左右子节点加入队列中
            for (TreeNode t : tcur){
                if (t.left != null)
                    queue.offer(t.left);
                if (t.right != null)
                    queue.offer(t.right);
            }
        }
        return res;
    }
}
