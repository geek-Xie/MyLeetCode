/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 * 示例1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 *
 * 示例2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
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
    public boolean isValidBST(TreeNode root) {
        return check(root,null,null);
    }

    /**
     * 利用二叉搜索树的性质，用递归的方法解决问题
     * @param root 当前的节点
     * @param minval 当前节点值的下界
     * @param maxval 当前节点值的上界
     * @return
     */
    private boolean check(TreeNode root, Integer minval, Integer maxval) {
        // 如果当前节点为空，返回true
        if (root == null)
            return true;
        // 记录当前节点的值
        int val = root.val;
        // 如果当前节点的值比下界小，返回false
        if (minval != null && val <= minval)
            return false;
        // 如果当前节点的值比上界大，返回false
        if (maxval != null && val >= maxval)
            return false;

        // 递归判断左右子树
        // 判断左子树的时候，当前节点的值就是上界，即左子树的所有节点的值都要比当前节点的值小
        if (!check(root.left,minval,val))
            return false;
        // 判断右子树的时候，当前节点的值就是下界，即右子树的所有节点的值都要比当前节点的值大
        if (!check(root.right,val,maxval))
            return false;

        return true;
    }
}
