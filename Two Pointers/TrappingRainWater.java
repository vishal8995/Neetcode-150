public class TrappingRainWater {

    // Prefix-Suffix Array solution: Storing max left and max right height of every
    // single position - O(n) time and space.
    public static int trap(int[] height) {

        int len = height.length;
        if (height == null || len == 0) {
            return 0;
        }

        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[len - 1] = height[len - 1];
        for (int j = len - 2; j >= 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j]);
        }

        int res = 0;
        for (int k = 0; k < len; k++) {
            res += Math.min(maxLeft[k], maxRight[k]) - height[k];
        }

        return res;
    }

    // Two Pointers solution: Finding max volume at each index
    // O(n) time and O(1) space solution
    public static int trap2(int[] height) {

        int len = height.length;
        if (height == null || len == 0) {
            return 0;
        }

        int res = 0;
        int l = 0, r = len - 1;
        int leftMax = height[l], rightMax = height[r];
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 }));

        System.out.println(trap2(new int[] { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 }));
    }

}
