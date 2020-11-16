/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
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
     * 此题的做法与 102. 二叉树的层序遍历 的做法十分类似，唯一不同的就是多了一个boolean类型的变量用来记录当前行的遍历的顺序是由左往右还是由右往左
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 记录当前行节点遍历的顺序
        boolean toRight = true;
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
            // 如果当前的行的遍历顺序是由右往左，则需要对列表进行翻转
            if (!toRight)
                Collections.reverse(cur);
            res.add(cur);
            //  改变下一行的遍历顺序
            toRight = !toRight;

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
