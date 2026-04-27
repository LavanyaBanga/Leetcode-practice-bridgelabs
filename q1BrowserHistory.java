public import java.util.*;

class Node {
    String url;
    Node prev, next;

    Node(String url) {
        this.url = url;
    }
}

public class q1BrowserHistory {

    Node current;

    public q1BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = null;
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
    }

    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    public static void main(String[] args) {
        q1BrowserHistory obj = new q1BrowserHistory("google.com");

        obj.visit("youtube.com");
        obj.visit("facebook.com");
        obj.visit("linkedin.com");

        System.out.println(obj.back(1));     // facebook
        System.out.println(obj.back(1));     // youtube
        System.out.println(obj.forward(1));  // facebook

        obj.visit("twitter.com");

        System.out.println(obj.forward(2));  // twitter
        System.out.println(obj.back(2));     // youtube
    }
} 
