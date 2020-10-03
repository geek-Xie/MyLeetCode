/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
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
     * 使用前后指针的方法解决删除链表倒数节点的问题
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义一个前置节点方便对链表进行操作
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 前指针
        ListNode p1 = pre;
        // 后指针
        ListNode p2 = pre;
        // 将两个指针之间的差距拉开为n，这样当前指针到达最后一个节点的时候，后指针刚好就是在第倒数n个节点的前置位置上
        for (int i = 0; i < n; i++)
            p1 = p1.next;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 进行节点的删除
        ListNode temp = p2.next.next;
        p2.next = temp;
        // 返回头节点
        return pre.next;
    }
}
