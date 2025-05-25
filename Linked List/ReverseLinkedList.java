
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        // Since by moving curr forward we intend to reach the next of the last node
        // which is usually null
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev; // Broke Connection between curr and next
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    // Helper to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Construct list [0, 1, 2, 3]
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode head = new ListNode(0, n1);

        System.out.print("Original list: ");
        printList(head);

        // Reverse
        ListNode reversed = reverseList(head);

        System.out.print("Reversed list: ");
        printList(reversed);
    }

}
