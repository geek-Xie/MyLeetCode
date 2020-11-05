/**
 * 92. 反转链表 II
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤m≤n≤ 链表长度。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    private boolean stop;
    private ListNode left;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        left = head;
        stop = false;
        recurseAndReverse(head, m, n);
        return head;
    }

    /**
     * 执行链表翻转的函数
     * @param right
     * @param m
     * @param n
     */
    private void recurseAndReverse(ListNode right, int m, int n) {
        // 如果终点就是起点，则直接返回
        if (n == 1)
            return;

        right = right.next;

        if (m > 1)
            this.left = this.left.next;

        recurseAndReverse(right, m - 1, n - 1);

        if (this.left == right || right.next == this.left)
            this.stop = true;

        if (!this.stop) {
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;

            this.left = this.left.next;
        }
    }
}
