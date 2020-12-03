/**
 * 143. 重排链表
 *
 * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */

import java.util.ArrayList;
import java.util.List;

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
     * 因为链表没办法使用下标直接访问节点，因此我们可以先将链表中的内容存储到一个数组列表中，然后再重建链表
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        // 将链表的内容存储到数组列表中
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int left = 0, right = list.size() - 1;
        // 重建链表
        while (left < right) {
            list.get(left).next = list.get(right);
            left++;
            if (left == right)
                break;

            list.get(right).next = list.get(left);
            right--;
        }
        list.get(left).next = null;
    }
}
