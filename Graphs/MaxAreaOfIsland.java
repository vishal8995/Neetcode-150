package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    private static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static int maxAreaOfIsland(int[][] grid) {

        int row = grid.length, col = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static int bfs(int[][] grid, int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = 0;
        q.add(new int[] { r, c });
        int area = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];
            for (int[] dir : directions) {

                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[] { nr, nc });
                    grid[nr][nc] = 0;
                    area++;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(
                new int[][] { { 0, 1, 1, 0, 1 }, { 1, 0, 1, 0, 1 }, { 0, 1, 1, 0, 1 }, { 0, 1, 0, 0, 1 } }));
    }

}
