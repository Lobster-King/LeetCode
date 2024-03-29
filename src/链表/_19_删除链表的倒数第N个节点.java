package 链表;

import java.util.ArrayList;
    /*
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

    示例：

    给定一个链表: 1->2->3->4->5, 和 n = 2.

    当删除了倒数第二个节点后，链表变为 1->2->3->5.
    说明：

    给定的 n 保证是有效的。

    进阶：

    你能尝试使用一趟扫描实现吗？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
public class _19_删除链表的倒数第N个节点 {

    /*
    * 有点类似快慢指针概念，两个指针保持n的距离，第一个指针先走n+1步。
    * 然后第二个指针从头开始走，直到第一个指针走到尾节点。
    * 则第二个指针所在的位置就是要删除的节点。
    * 注意边界处理。
    * */
    public static ListNode removeNthFromEndImp2(ListNode head,int n) {
        ListNode cusorNode = new ListNode(0);
        cusorNode.next = head;

        ListNode firstNode = cusorNode;
        ListNode secondNode = cusorNode;

        /*第一个指针先走n+1步*/
        for (int i = 1; i < n + 1; i++) {
            firstNode = firstNode.next;
        }

        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;

        }

        /*此时的second节点已经是我们要删除的前一个节点*/
        secondNode.next = secondNode.next.next;
        return cusorNode.next;

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         * 空间换时间，用一个数组存储所有节点，遍历链表计算出size。
         * head->1->2->3->4->5
         * */

        ArrayList list = new ArrayList();
        ListNode originHead = head;
        int size = 0;
        while (head != null) {
            list.add(head);
            head = head.next;
            size++;
        }

        if (n == 1) {
            /*移除尾节点*/
            if (size == 1) return originHead.next = null;
            ListNode preNode = (ListNode) list.get(size - 2);
            preNode.next = null;
        } else if (n == size - 1) {
            /*移除头节点*/
            if (size == 1) return originHead.next = null;
            originHead = (ListNode) list.get(2);
        } else {
            /*移除中间元素*/
            ListNode preNode = (ListNode) list.get(size - n - 1);
            ListNode subNode = (ListNode) list.get(size - n + 1);
            preNode.next = subNode;
        }
        return originHead;
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(0);
        ListNode cusorNode = headNode;
        for (int i = 1; i < 6; i++) {
            cusorNode.next = new ListNode(i);
            cusorNode = cusorNode.next;
            if (i == 5) cusorNode.next = null;
        }

        ListNode head =  removeNthFromEnd(headNode,5);

        System.out.println(head);


    }
}
