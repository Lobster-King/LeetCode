package 链表;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

    示例 1:

    输入: 1->2->3->3->4->4->5
    输出: 1->2->5
    示例 2:

    输入: 1->1->1->2->3
    输出: 2->3

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
public class _82_删除排序链表中的重复元素II {
    public static ListNode deleteDuplicates(ListNode head) {
        ArrayList<Integer> dataArray = new ArrayList<>();
        ArrayList<Integer> removeArray = new ArrayList<>();//需要移除的元素的值
        ListNode cusorNode = new ListNode(-1);
        cusorNode.next = head;
        while (cusorNode.next != null) {
            if (dataArray.contains(cusorNode.next.val)) {
                removeArray.add(cusorNode.next.val);
            } else  {
                dataArray.add(cusorNode.next.val);
            }
            cusorNode = cusorNode.next;
        }
        cusorNode = new ListNode(-1);
        cusorNode.next = head;

        while (cusorNode.next != null) {
            if (removeArray.contains(cusorNode.next.val)) {
                /*移除该元素*/
                cusorNode.next = cusorNode.next.next;
            } else  {
                cusorNode = cusorNode.next;
            }


        }

        return head;
    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(-1);
        ListNode cusorNode = headNode;
        for (int i = 1; i < 4; i++) {
            cusorNode.next = new ListNode(1);
            cusorNode = cusorNode.next;
        }

        cusorNode.next = new ListNode(2);
        cusorNode = cusorNode.next;

        cusorNode.next = new ListNode(3);
        cusorNode = cusorNode.next;

        deleteDuplicates(headNode.next);
    }

}
