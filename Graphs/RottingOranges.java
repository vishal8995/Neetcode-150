package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    static class Pair {
        int r;
        int c;
        int tm;

        Pair(int row, int col, int time) {
            this.r = row;
            this.c = col;
            this.tm = time;
        }
    }

    public static int orangesRotting(int[][] grid) {

        int row = grid.length, col = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[row][col];
        int freshCtr = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                } else
                    vis[i][j] = 0;

                if (grid[i][j] == 1)
                    freshCtr++;
            }
        }

        int time = 0;
        int rotCtr = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.r;
            int c = p.c;
            int tm = p.tm;
            time = Math.max(time, tm);

            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < row && nc < col
                        && vis[nr][nc] == 0 && grid[nr][nc] == 1) {
                    q.add(new Pair(nr, nc, tm + 1));
                    vis[nr][nc] = 2;
                    rotCtr++;
                }
            }
        }

        if (freshCtr != rotCtr)
            return -1;
        else
            return time;

    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(orangesRotting(grid));
    }
}
