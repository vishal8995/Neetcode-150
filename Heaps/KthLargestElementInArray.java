package Heaps;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();

    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 2, 3, 1, 5, 4 }, 2));
        System.out.println(findKthLargest(new int[] { 2, 3, 1, 1, 5, 5, 4 }, 3));
    }

}
