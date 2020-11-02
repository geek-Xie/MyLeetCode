/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 如果链表是空的或者只有一个头节点，则直接返回
        if (head == null || head.next == null)
            return head;

        // 使用前后指针进行链表的遍历并判断是否出现重复，执行删除操作
        ListNode pre = head;
        ListNode cur = pre.next;

        while (cur != null) {
            // 如果前后节点重复
            if (cur.val == pre.val) {
                // 删除后面重复的节点
                pre.next = cur.next;
                cur = cur.next;

            }
            // 如果前后节点并不重复，则直接往后移动
            else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        // 返回头节点
        return head;
    }
}
