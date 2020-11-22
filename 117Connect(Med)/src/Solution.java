/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 */

import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {
    /**
     * 使用树的广度优先搜索的思路解决问题
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Deque<Node> queue = new LinkedList<>();
        List<Node> list = new ArrayList<>();

        if (root == null)
            return null;
        queue.offer(root);

        // 基于树的广度优先搜索的过程
        while (!queue.isEmpty()) {
            // 将当前这一层的树的节点拿出来放到list中
            while (!queue.isEmpty())
                list.add(queue.pollFirst());
            // 为当前这一层的树的节点处理他们的next指针
            for (int i = 0; i < list.size() - 1; i++)
                list.get(i).next = list.get(i + 1);
            list.get(list.size() - 1).next = null;
            // 将下一层的节点添加到队列中
            for (Node n : list) {
                if (n.left != null)
                    queue.offer(n.left);
                if (n.right != null)
                    queue.offer(n.right);
            }
            // 清空list
            list.clear();
        }
        return root;
    }
}
