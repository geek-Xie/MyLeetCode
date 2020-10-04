/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
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
     * 使用迭代的方式进行节点位置的交换，思路不难理解，难点是节点指针在位置交换时候的处理
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // 创建一个虚拟的头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // 拿到当前需要进行交换的两个节点
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // 进行节点位置的交换
            prevNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // 将处理的pre指针和head指针移动到下一个需要处理的位置
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        return dummy.next;
    }
}
