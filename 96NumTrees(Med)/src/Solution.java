/**
 * 96. 不同的二叉搜索树
 *
 * 给定一个整数 n，求以1 ...n为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */

public class Solution {
    /**
     * 动态规划来解决问题
     * G(n)表示长度为n的序列能构成的二叉搜索树的数目,G(0) = G(1) = 1
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // 动态规划数组
        int[] G = new int[n + 1];
        // 设置初始条件
        G[0] = 1;
        G[1] = 1;

        // i表示序列长度
        for (int i = 2; i <= n; ++i) {
            // j表示在当前的i长度下所选取的根节点
            for (int j = 1; j <= i; ++j) {
                // 当前长度的序列的搜索二叉树的总数量等于当前序列的所有节点分别为根节点的情况下的情况和
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
