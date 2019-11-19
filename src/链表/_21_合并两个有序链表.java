package 链表;


    /*
    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

    示例：

    输入：1->2->4, 1->3->4
    输出：1->1->2->3->4->4

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
public class _21_合并两个有序链表 {
    public static void main(String[] args) {


    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        * 思路一：笨方法双层循环，进行比较大小
        * 思路二：对于两个链表l1 l2，若l1小于l2，则让哨兵链表的next指向l1，然后l1向后移动一个指针。若l2小，同样操作。执行完毕之后哨兵对象啊你个也
        * 挪动位置，直到其中链表为空，则剩余的链表肯定是有序的而且是大于哨兵对象的元素的，则直接连接即可。
        * */

        ListNode headNode = new ListNode(-1);
        ListNode sentryNode = headNode;
        while (l1 != null && l2 != null ) {
            if (l1.val <= l2.val) {
                sentryNode.next = l1;
                l1 = l1.next;
            } else {
                sentryNode.next = l2;
                l2 = l2.next;
            }
            sentryNode = sentryNode.next;
        }

        /*l1或者l2为空，停止循环*/
        sentryNode.next = l1 == null ? l2 : l1;

        return headNode.next;
    }

}
