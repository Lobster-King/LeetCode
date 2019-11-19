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
        ArrayList<Integer> duplicatedArray = new ArrayList<>();

        if (head == null || head.next == null) return head;

        ListNode curNode = head.next;
        ListNode preNode = head;


        //将重复的数字放到一个数组中
        while (preNode != null) {
            if (dataArray.contains(preNode.val)) {
                if (!duplicatedArray.contains(preNode.val)) {
                    duplicatedArray.add(preNode.val);//记录哪个数值是重复的
                }
            } else {
                dataArray.add(preNode.val);
            }
            preNode = preNode.next;
        }

        //进行删除操作
        preNode = head;

        while (curNode != null) {
            if (duplicatedArray.contains(curNode.val)) {
                //若包含此元素，则删除之
                curNode = curNode.next;
                preNode.next = curNode;
            } else {
                //不包含则移动下标
                curNode = curNode.next;
                preNode = preNode.next;
            }

        }

        //注意第一个是没有进行检查的
        if (duplicatedArray.contains(head.val)) {
            //移除第一个元素
            return head.next;
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
