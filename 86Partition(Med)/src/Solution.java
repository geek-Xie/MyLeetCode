/**
 * 86. 分隔链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        // 存储比x值小的节点的链表
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        // 存储比x值大的节点的链表
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {
            // 如果当前节点的值比x小，则添加到before链表中
            if (head.val < x) {
                before.next = head;
                before = before.next;
            }
            // 如果当前节点的值比x大，则添加到after链表中
            else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        // 将before链表和after链表连接起来
        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }
}
