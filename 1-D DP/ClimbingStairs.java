
public class ClimbingStairs {

    // Recursion : O(2^n)
    public static int climbStairs(int n) {
        return dfs(n, 0);
    }

    public static int dfs(int n, int i) {
        if (i >= n)
            return i == n ? 1 : 0;

        return dfs(n, i + 1) + dfs(n, i + 2);
    }

    // DP Top Down : O(n)
    static int[] cache;

    public static int climbStairs2(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++)
            cache[i] = -1;
        return dfs2(n, 0);
    }

    public static int dfs2(int n, int i) {
        if (i >= n)
            return i == n ? 1 : 0;

        if (cache[i] != -1)
            return cache[i];

        return cache[i] = dfs2(n, i + 1) + dfs(n, i + 2);
    }

    // DP Bottom Up Space Optimized: O(n); Space - O(1)
    public static int climbStairs3(int n) {
        int one = 1, two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
        System.out.println(climbStairs3(5));
    }
}
