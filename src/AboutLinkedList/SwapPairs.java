package AboutLinkedList;

import java.util.List;

// 24. Swap Nodes in Pairs
// https://leetcode.com/problems/swap-nodes-in-pairs/description/
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while(p.next != null && p.next.next != null ){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            p = node1;
        }

        return dummyHead.next;
    }

    public ListNode MySwapPairs(ListNode head){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;

        while(p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            //交换顺序
            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new SwapPairs()).MySwapPairs(head);
        System.out.println(head);
    }
}
