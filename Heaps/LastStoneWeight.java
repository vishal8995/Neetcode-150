package Heaps;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int s : stones)
            maxHeap.offer(-s); // Since we need MaxHeap, but java supports minHeap only we add negative weights

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll(); // Highest Value
            int second = maxHeap.poll(); // Second Highest Value

            // If the second is greater than first, we offer difference. If equal, both
            // removed. ALSO, We do second > first because -ve of large number is smaller
            // than -ve of a smaller number. To actually subtract smaller from larger,
            // second > first. Also this is a minHeap working as a maxHeap.
            if (second > first)
                maxHeap.offer(first - second);
        }

        // To counter NPE if heap is empty, if not anyway the top would have value
        // greater (In this case -ve) than zero
        maxHeap.offer(0);
        return Math.abs(maxHeap.peek());
    }

    public static void main(String[] args) {

        System.out.println(lastStoneWeight(new int[] { 2, 3, 6, 2, 4 }));
        System.out.println(lastStoneWeight(new int[] { 2, 2 }));
    }

}
