/**
 * 82. 删除排序链表中的重复元素 II
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复出现的数字。
 *
 * 示例1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 *
 * 示例2:
 * 输入: 1->1->1->2->3
 * 输出: 2->3
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
        // 如果链表是空的或者链表只有一个节点，则可以直接返回
        if (head == null || head.next == null)
            return head;
        // 在头节点head前面再防止一个前驱节点，方便操作
        ListNode pre = new ListNode(-1);
        pre.next = head;

        // 使用前后指针的方法解决问题
        ListNode a = pre;
        ListNode b = head;

        while (b != null && b.next != null) {
            // 如果此时前后指针指向的值不相同，则同时向后移动
            if (a.next.val != b.next.val) {
                a = a.next;
                b = b.next;
            }
            // 如果前后指针指向的值相同，即出现了重复的值
            else {
                // 将后指针不断向后移动知道两个指针指向的值不同
                while (b != null && b.next != null && a.next.val == b.next.val)
                    b = b.next;

                // 调整指针，将重复的元素节点删去
                a.next = b.next;
                b = b.next;
            }
        }
        // 返回新的头节点
        return pre.next;
    }
}
