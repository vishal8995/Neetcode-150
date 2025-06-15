package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    private static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Calculate Rows and Cols Length
        int ROWS = heights.length, COLS = heights[0].length;

        // Create two different visited arrays for bot pacific and atlantic side
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // Queues used for BFS
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        // Populate the Queues with border indexes of both sides into their respective
        // queues
        for (int r = 0; r < ROWS; r++) {
            pacQ.add(new int[] { r, 0 });
            atlQ.add(new int[] { r, COLS - 1 });
        }

        for (int c = 0; c < COLS; c++) {
            pacQ.add(new int[] { 0, c });
            atlQ.add(new int[] { ROWS - 1, c });
        }

        // Run BFS to find the paths from ocean to a delta of height in increasing
        // order.
        bfs(pacQ, pacific, heights);
        bfs(atlQ, atlantic, heights);

        // Finally check if both the visited arrays have locations which are true and
        // common to both grids
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public static void bfs(Queue<int[]> q, boolean[][] vis, int[][] heights) {
        while (!q.isEmpty()) {

            int[] node = q.poll();
            int row = node[0], col = node[1];
            vis[row][col] = true;

            for (int[] d : directions) {
                int nr = row + d[0], nc = col + d[1];

                // Check if the location is not already visited and height coming from border is
                // smaller than the next
                if (nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && !vis[nr][nc]
                        && heights[nr][nc] >= heights[row][col]) {
                    q.add(new int[] { nr, nc });
                }
            }

        }
    }

    public static void main(String[] args) {

        List<List<Integer>> result = pacificAtlantic(
                new int[][] { { 4, 2, 7, 3, 4 }, { 7, 4, 6, 4, 7 }, { 6, 3, 5, 3, 6 } });

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
