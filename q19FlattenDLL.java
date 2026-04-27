 import java.util.*;

class Node {
    int val;
    Node prev, next, child;

    Node(int val) {
        this.val = val;
    }
}

public class q19FlattenDLL {

    public static void main(String[] args) {
        // simple test (manual testing complex hota hai)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;

        q19FlattenDLL obj = new q19FlattenDLL();
        head = obj.flatten(head);

        obj.printList(head);
    }

    public Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr != null) {

            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }

            if (curr.next == null && !stack.isEmpty()) {
                Node temp = stack.pop();
                curr.next = temp;
                temp.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
} 