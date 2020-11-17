/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    // 后序遍历的下标
    int post_idx;
    // 后序遍历序列
    int[] postorder;
    // 中序遍历序列
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立中序遍历的键值对哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        return build(0, inorder.length - 1);
    }

    /**
     * @param in_left 中序遍历序列的左下标
     * @param in_right 中序遍历序列的右下标
     * @return
     */
    private TreeNode build(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right)
            return null;

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        // 建立根节点
        TreeNode root = new TreeNode(root_val);

        // 当前根节点在中序遍历序列中的位置
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = build(index + 1, in_right);
        // 构造左子树
        root.left = build(in_left, index - 1);
        return root;
    }
}
