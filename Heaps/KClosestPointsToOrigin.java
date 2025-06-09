package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static int[][] kClosest(int[][] points, int k) {

        // PQ saves an Integer array {dist, x, y}. Uses Comparator for Heapify,
        // comparing a[0] that is distance.
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[] { dist, point[0], point[1] });
        }

        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();
            res[i] = new int[] { point[1], point[2] };
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] res = kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2);
        for (int[] i : res) {
            for (int j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

}