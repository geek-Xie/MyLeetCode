/**
 * 142. 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 */

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 首先判断链表是否有环
        boolean hascycle = checked(head);
        // 如果链表是有环的
        if (hascycle) {
            Map<ListNode, ListNode> map = new HashMap<>();
            ListNode pre = head;
            // 遍历链表
            while (pre != null) {
                // 如果之前没有这个节点，加入集合
                if (!map.containsKey(pre))
                    map.put(pre, pre.next);
                // 如果之前见过这个节点，则他就是环的入环节点，直接返回
                else
                    return pre;
                // 移动遍历指针
                pre = pre.next;
            }
        }
        // 否则链表就是无环的，返回null
        return null;
    }

    /**
     * 判断当前链表是否有环的方法
     * @param head
     * @return
     */
    private boolean checked(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
