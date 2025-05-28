public class RemoveNodeFromEnd {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int removeIndex = len - n;
        if (removeIndex == 0)
            return head.next;

        curr = head;
        for (int i = 0; i < len - 1; i++) {
            if (i + 1 == removeIndex) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }

        return head;

    }

    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        System.out.print("Original List: ");
        printList(head);

        // Remove 2nd node from end (should remove 4)
        head = removeNthFromEnd(head, 2);

        System.out.print("After Removing 2nd from End: ");
        printList(head);
    }

}
