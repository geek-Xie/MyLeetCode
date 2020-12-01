/**
 * 138. 复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。
 *
 * 我们用一个由n个节点组成的链表来表示输入/输出中的链表。每个节点用一个[val, random_index]表示：
 *
 * val：一个表示Node.val的整数。
 * random_index：随机指针指向的节点索引（范围从0到n-1）；如果不指向任何节点，则为null。
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 */

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node() {

    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}


public class Solution {
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        // 如果头节点是空的，则返回null
        if (head == null)
            return null;

        // 如果测试Map中已经有了当前节点，则直接返回
        if (this.visitedHash.containsKey(head))
            return this.visitedHash.get(head);

        // Map中没有当前节点，则新建一个节点
        Node node = new Node(head.val, null, null);

        this.visitedHash.put(head, node);

        // 顺着next指针进行构造
        node.next = this.copyRandomList(head.next);
        // 顺着random指针进行构造
        node.random = this.copyRandomList(head.random);

        return node;
    }
}
