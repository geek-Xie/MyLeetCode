/**
 * 61. 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 *
 * 示例1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 *
 * 示例2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步:0->1->2->NULL
 * 向右旋转 4 步:2->0->1->NULL
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    /**
     * 算法的设计思路是先将单链表首尾相接构成循环链表，然后根据移动的k值对头指针进行移动，
     * 移动到新链表的头节点处，再将循环链表断成单链表
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        // 如果头节点为空，直接返回null
        if (head == null)
            return null;
        // 如果旋转的次数是0，则返回原链表
        if (k == 0)
            return head;
        // 单链表的尾节点，也是循环链表中头节点的前驱节点
        ListNode pre = head;
        // 记录链表的长度
        int length = 1;
        while (pre.next != null) {
            pre = pre.next;
            length++;
        }
        // 首尾相连成循环链表
        pre.next = head;
        // 根据k值计算出头节点需要移动的步数
        int steps = length - (k % length);
        // 对头节点和前驱节点进行移动
        for (int i = 0; i < steps; i++) {
            pre = pre.next;
            head = head.next;
        }
        // 断成单链表
        pre.next = null;
        // 返回头节点
        return head;
    }
}
