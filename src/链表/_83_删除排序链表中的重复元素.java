package 链表;

import java.util.ArrayList;

public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {

        //1->2->3->3->3
        ArrayList<Integer> dataArray = new ArrayList<>();
        if (head == null || head.next == null) return head;

        ListNode curNode = head.next;
        ListNode preNode = head;
        dataArray.add(preNode.val);
        while (curNode != null) {
            if (dataArray.contains(curNode.val)) {
                //若包含此元素，则删除之
                curNode = curNode.next;
                preNode.next = curNode;
            } else {
                //不包含则加到数组中
                dataArray.add(curNode.val);
                curNode = curNode.next;
                preNode = preNode.next;
            }

        }
        return head;
    }
}
