/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
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
     * 由二叉搜索树的性质我们可以知道，如果一个排序数组想要组成二叉搜索树，那么这个数组的序列一定是这个二叉搜索树的中序遍历序列
     * 但是只知道中序遍历我们无法构造出唯一的一棵二叉搜索树，就算再加上一个高度平衡的条件也不行，因此我们就每次都选取当前序列的中间元素作为当前的根节点，
     * 然后左边的元素就是这个根节点左子树的内容，右边的元素就是根节点右子树的内容，递归构造
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right)
            return null;

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        // 构造节点
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构造左子树
        root.left = build(nums, left, mid - 1);
        // 递归构造右子树
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
