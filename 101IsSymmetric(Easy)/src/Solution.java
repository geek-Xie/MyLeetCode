/**
 * 101. 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
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
    /**
     * 思路就是让每一个节点的左右两棵子树互为镜像，那么整棵树就是对称的二叉树了
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        // 如果当前的两个节点都是null，返回true
        if (p == null && q == null)
            return true;
        // 如果当前的两个节点只有一个存在，那么肯定不是一棵镜像二叉树，返回false
        if (p == null || q == null)
            return false;
        // 判断当前的两个节点是否的值是否相等，并且相互的左右子树是否互为镜像
        else
            return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }
}
