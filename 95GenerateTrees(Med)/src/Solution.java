/**
 * 95. 不同的二叉搜索树 II
 *
 * 给定一个整数 n，生成所有由 1 ...n 为节点所组成的 二叉搜索树 。
 * 二叉搜索树的特点就是左节点小于根节点且右节点大于根节点
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *  [1,null,3,2],
 *  [3,2,null,1],
 *  [3,1,null,null,2],
 *  [2,1,3],
 *  [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

import java.util.LinkedList;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
        // 如果是0，则直接返回空列表
        if (n == 0) {
            return new LinkedList<>();
        }
        // 否则调用方法返回
        return generateTrees2(1, n);
    }

    /**
     * 使用递归的思路
     * @param start 序列的起点位置
     * @param end 序列的终点位置
     * @return
     */
    public List<TreeNode> generateTrees2(int start, int end) {
        // 存储树节点分布的列表
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点，将当前序列分为两个部分
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees2(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees2(i + 1, end);

            // 从左子树集合中选出一棵左子树
            for (TreeNode left : leftTrees) {
                // 从右子树集合中选出一棵右子树，与左子树拼接到根节点上
                for (TreeNode right : rightTrees) {
                    // 拿到根节点
                    TreeNode currTree = new TreeNode(i);
                    // 拼接
                    currTree.left = left;
                    currTree.right = right;
                    // 添加到结果列表中
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
