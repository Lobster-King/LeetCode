package 链表;

/*
 *https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * */
public class _23_合并K个排序链表 {
    public static void main(String[] args) {

    }

    /*
    * 思路一：笨方法循环遍历链表数组，进行合并，合并之后将合并后链表覆盖第二个位置。
    * */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode headNode = new ListNode(-1);
        for (int i = 0; i < lists.length; i++) {
            ListNode firstNode = lists[i];
            if (i == lists.length-1) return firstNode;
            ListNode secondNode = lists[i+1];
            lists[i+1] = mergeTwoLists(firstNode,secondNode);
        }

        return headNode.next;
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2) {
        ListNode headNode = new ListNode(-1);
        ListNode sentryNode = headNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                sentryNode.next = l1;
                l1 = l1.next;
            } else  {
                sentryNode.next = l2;
                l2 = l2.next;
            }

            sentryNode = sentryNode.next;
        }
        sentryNode.next = l1 == null ? l2 : l1;
        return headNode.next;
    }

}
