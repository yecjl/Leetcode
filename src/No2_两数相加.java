public class No2_两数相加 {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = newListNode(new int[]{5,5});
        ListNode node2 = newListNode(new int[]{5,5});
        ListNode node = addTwoNumbers(node1, node2);
        printListNode(node);

    }

    private static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    private static ListNode newListNode(int[] num) {
        ListNode root = new ListNode(num[0]);
        ListNode p = root;
        for (int i = 1; i < num.length; i++) {
            ListNode node = new ListNode(num[i]);
            p.next = node;
            p = node;
        }
        return root;
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode root = null;
        ListNode p = null;
        int remain = 0;
        while (p1 != null || p2 != null) {
            int p1Num = 0;
            int p2Num = 0;
            if (p1 != null) {
                p1Num = p1.val;
            }
            if (p2 != null) {
                p2Num = p2.val;
            }
            int sum = p1Num + p2Num + remain;
            remain = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (root == null) {
                root = node;
            } else {
                p.next = node;
            }
            p = node;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (remain != 0) {
            p.next = new ListNode(remain);
        }
        return root;
    }

    // 类似的，但是有些有些缩减
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p != null || q != null) {
//            int x = (p != null) ? p.val : 0;
//            int y = (q != null) ? q.val : 0;
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }
}