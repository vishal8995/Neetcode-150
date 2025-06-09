package Heaps;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k)
                minHeap.poll();
        }
    }

    public int add(int val) {

        minHeap.add(val);
        if (minHeap.size() > k)
            minHeap.poll();

        return minHeap.peek();

    }

    public static void main(String[] args) {
        KthLargestElementInStream kthLargest = new KthLargestElementInStream(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3)); // 4
        System.out.println(kthLargest.add(5)); // 5
        System.out.println(kthLargest.add(10)); // 5
        System.out.println(kthLargest.add(9)); // 8
        System.out.println(kthLargest.add(4)); // 8

        KthLargestElementInStream kthLargest2 = new KthLargestElementInStream(3, new int[] { 1, 2, 3, 3 });
        System.out.println(kthLargest2.add(3)); // 3
        System.out.println(kthLargest2.add(5)); // 3
        System.out.println(kthLargest2.add(6)); // 3
        System.out.println(kthLargest2.add(7)); // 5
        System.out.println(kthLargest2.add(8)); // 6
    }

}
