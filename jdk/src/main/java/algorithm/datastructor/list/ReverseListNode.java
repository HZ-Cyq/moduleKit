package algorithm.datastructor.list;

public class ReverseListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode reverse = reverse(node1);
        System.out.println(reverse);
    }

    public static ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode q = head.next;
        p.next = null;
        while (q != null) {
            ListNode third = q.next;
            q.next = p;

            p = q;
            q = third;
        }
        return p;
    }

}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
