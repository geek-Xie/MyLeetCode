/**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */

import java.util.*;

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
     * 使用比较简单的解题思路，将原来链表中的元素值转化到list中进行排序操作然后在重新生成链表，但是时间复杂度比较高
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode pre = head;
        while (pre != null) {
            list.add(pre.val);
            pre = pre.next;
        }
        Collections.sort(list);
        ListNode prenode = new ListNode(-1);
        ListNode cur = prenode;
        for (int i : list) {
            ListNode newnode = new ListNode(i);
            cur.next = newnode;
            cur = newnode;
        }
        return prenode.next;
    }
}
