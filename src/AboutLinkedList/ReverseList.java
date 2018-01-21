package AboutLinkedList;

// 206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/description/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class ReverseList {


    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode myReverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;

        while (cur !=null){
            next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode head2 = (new ReverseList()).myReverseList(head);
        System.out.println(head2);
    }
}
