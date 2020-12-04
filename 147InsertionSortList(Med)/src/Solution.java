/**
 * 147. 对链表进行插入排序
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例2：
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;

        // 定义一个前置节点，方便操作
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 最后一个排序好的节点
        ListNode lastSorted = head;
        // 当前要参加排序的节点
        ListNode curr = head.next;
        while (curr != null) {
            // 如果比排好序的最后一个都要大，则直接插入在排序好的部分之后
            if (lastSorted.val <= curr.val)
                lastSorted = lastSorted.next;

            else {
                // 从头开始找
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val)
                    prev = prev.next;
                // 进行插入操作
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
