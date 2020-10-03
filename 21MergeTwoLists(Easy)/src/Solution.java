/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class Solution {
    /**
     * 使用双指针的方法进行插入
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 指向第一个链表的指针
        ListNode p1 = l1;
        // 指向第二个链表的指针
        ListNode p2 = l2;
        // 定义一个头指针方便对链表进行操作
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                ListNode t = new ListNode(p2.val);
                pre.next = t;
                pre = t;
                p2 = p2.next;
            }
            else {
                ListNode t = new ListNode(p1.val);
                pre.next = t;
                pre = t;
                p1 = p1.next;
            }
        }
        if (p1 == null){
            pre.next = p2;
        }
        else
            pre.next = p1;

        return head.next;
    }
}
