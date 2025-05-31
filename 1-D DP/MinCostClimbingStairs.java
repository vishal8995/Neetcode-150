
public class MinCostClimbingStairs {

    // Recursion: O(2^n)
    public static int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    static int dfs(int[] cost, int i) {
        if (i >= cost.length)
            return 0; // When we reach index 3,4 beyond the last 2 in our array, the cost becomes 0

        return cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
    }

    // DP Top Down
    static int[] memo;

    public static int minCostClimbingStairs2(int[] cost) {
        memo = new int[cost.length];
        return Math.min(dfs2(cost, 0), dfs2(cost, 1));
    }

    static int dfs2(int[] cost, int i) {
        if (i >= cost.length)
            return 0;

        if (memo[i] != -1)
            return memo[i];

        return memo[i] = cost[i] + Math.min(dfs2(cost, i + 1), dfs2(cost, i + 2));
    }

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }));
    }

}
