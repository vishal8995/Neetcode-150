public class CycleDetection {

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

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;

    }

    public static void main(String[] args) {
        // List 1: 1 -> 2 -> 3 -> 4 -> 2 (cycle)
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a2; // cycle here

        // List 2: 5 -> 6 -> 7 -> 8 -> 6 (cycle)
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(7);
        ListNode b4 = new ListNode(8);
        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b2; // cycle here

        // List 3: 9 -> 10 -> 11 (no cycle)
        ListNode c1 = new ListNode(9);
        ListNode c2 = new ListNode(10);
        ListNode c3 = new ListNode(11);
        c1.next = c2;
        c2.next = c3;

        // Check cycles
        System.out.println("List 1 has cycle: " + hasCycle(a1));
        System.out.println("List 2 has cycle: " + hasCycle(b1));
        System.out.println("List 3 has cycle: " + hasCycle(c1));
    }

}
