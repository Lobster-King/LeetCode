package 链表;

    public class _2_两数相加 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode headNode = new ListNode(0);
            ListNode cusorNode = headNode;
            int carry = 0;/*代表进位*/
            while (l1 != null || l2 != null) {
                int x = (l1 != null)?l1.val:0;
                int y = (l2 != null)?l2.val:0;
                int sum = carry + x + y;
                carry = sum / 10;
                cusorNode.next = new ListNode(sum % 10);
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            if (carry > 0) {
                cusorNode.next = new ListNode(carry);
            }
            return headNode.next;
        }

        public static void main(String[] args) {

            return;
        }
    }


