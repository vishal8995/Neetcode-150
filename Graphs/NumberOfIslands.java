package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    private static final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static int numIslands(char[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    public static void bfs(char[][] grid, int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[] { r, c });

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for (int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nc >= 0 &&
                        nr < grid.length && nc < grid[0].length &&
                        grid[nr][nc] == '1') {

                    q.add(new int[] { nr, nc });
                    grid[nr][nc] = '0';
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] { { '0', '1', '1', '1', '0' }, { '0', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
    }

}

// ✅ Steps to Solve “Number of Islands”
// 1. Loop through each cell in the 2D grid.
// 2. If a cell contains '1' (land):
// • It’s part of a new island → increment island count.
// • Call bfs() to explore the entire island and mark all connected '1's as
// visited.
// 3. In bfs(), traverse in 4 directions and mark all reachable '1' cells as
// '0'.
// 4. Continue scanning the grid until all land is marked.
// 5. Return the total island count.

// ⸻

// 🔁 BFS Traversal Steps (Verbose Version)

// Step 1: Setup
// • Initialize a queue (Queue<int[]>)
// • Mark the starting cell (r, c) as visited by setting grid[r][c] = '0'
// • Enqueue that cell to start BFS

// Step 2: Start Traversal
// • While the queue is not empty:
// • Dequeue the front cell → call it (row, col)
// • For each of the 4 directions (up, down, left, right):
// • Compute the new position (nr, nc)
// • Check boundary conditions: must be within grid bounds
// • Check if the neighbor cell is '1' (land and unvisited)
// • If so:
// • Mark it as '0' immediately (visited)
// • Enqueue (nr, nc) for further traversal

// Step 3: End Condition
// • BFS ends when the queue is empty — i.e., all reachable land cells for this
// island are explored
// • You now return to numIslands() and continue scanning for the next '1'