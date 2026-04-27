
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class q10LL2 {

    public static void main(String[] args) {
        // 1->2->3->4->5->3...
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third; // cycle

        q10LL2 obj = new q10LL2();
        ListNode res = obj.detectCycle(head);

        if (res != null)
            System.out.println("Cycle starts at: " + res.val);
        else
            System.out.println("No cycle");
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        // detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}