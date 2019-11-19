package 链表;

    /*
    给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

    k 是一个正整数，它的值小于或等于链表的长度。

    如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    示例 :

    给定这个链表：1->2->3->4->5

    当 k = 2 时，应当返回: 2->1->4->3->5

    当 k = 3 时，应当返回: 3->2->1->4->5

    说明 :

    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
public class _25_K个一组翻转链表 {
    public static void main(String[] args) {
        ListNode headNode = new ListNode(-1);
        ListNode cusorNode = headNode;
        for (int i = 1; i < 6; i++) {
            cusorNode.next = new ListNode(i);
            cusorNode = cusorNode.next;
            if (i == 5) cusorNode.next = null;
        }

        ListNode head =  reverseKGroup(headNode.next,3);
        System.out.println(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode currNode = head;//步长为k（小于或等于链表的长度）
        ListNode headNode = head;//新的头指针
        ListNode tailNode = null;//新链表的尾节点
        ListNode remianNode = null;

        while (currNode != null) {
            for (int i = 0; i < k; i++) {
                if (currNode.next == null && i <= k-2)
                currNode = currNode.next;
            }
            remianNode = currNode.next;
        }


        return null;

    }

    private static ListNode reverseLink(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
