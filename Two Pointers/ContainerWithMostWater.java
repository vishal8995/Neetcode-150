public class ContainerWithMostWater {

    public static int maxArea(int[] heights) {

        int len = heights.length;
        int max = 0;
        int l = 0, r = len - 1;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);

            max = Math.max(max, area);

            if (heights[l] < heights[r])
                l++;
            else
                r--;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 7, 2, 5, 4, 7, 3, 6 }));
        // System.out.println(maxArea(new int[] { 2, 2, 2 }));
    }

}
