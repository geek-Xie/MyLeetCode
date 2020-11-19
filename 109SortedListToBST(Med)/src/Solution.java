/**
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    /**
     * 采用与 108. 将有序数组转换为二叉搜索树 一致的思路，多了一步将链表转化为有序数组的操作，详细思路见 108. 将有序数组转换为二叉搜索树
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode pre = head;
        while (pre != null) {
            pre = pre.next;
            size++;
        }

        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = head.val;
            head = head.next;
        }
        return build(nums, 0, size - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int med = (right + left) / 2;
        TreeNode root = new TreeNode(nums[med]);

        root.left = build(nums, left, med - 1);
        root.right = build(nums, med + 1, right);

        return root;
    }
}
