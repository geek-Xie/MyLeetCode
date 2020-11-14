/**
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 *
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 *
 * 示例3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
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
    /**
     * 使用递归的思路解决问题
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 首先是当前的两个节点都是空的情况，直接返回true
        if (p == null && q == null)
            return true;
        // 如果两个节点只有一个为空，则当前两棵树明显是不一样的，返回false
        else if (p == null || q == null)
            return false;
        // 如果当前的节点都存在，但是节点值不一样，返回false
        else if (p.val != q.val)
            return false;
        // 否则就是当前的节点都一样，继续判断当前节点的左右子树的情况
        else
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
