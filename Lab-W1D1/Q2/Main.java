package Q2;

public class Main {

    public static void main(String[] args) {
        var node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode tempNode = node;

        System.out.println("Node before reverse: ");
        while(tempNode != null) {
            System.out.println(tempNode.val);
             tempNode = tempNode.next;
        }

        System.out.println("Node after reverse: ");
        var reversedNode = reverseList(node);
        while(reversedNode != null) {
            System.out.println(reversedNode.val);
            reversedNode = reversedNode.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}

