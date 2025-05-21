public class FindMinInRoatedSortedArray {

    public static int findMin(int[] nums) {

        int l = 0, r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {

            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int m = l + (r - l) / 2;
            res = Math.min(res, nums[m]);
            // When st < m, Left Sorted -> Since we already had the min as nums[l] and if
            // left is sorted, that means all other values in this left half would be
            // greater than current res, so no point checking here.
            if (nums[l] <= nums[m])
                l = m + 1;
            else
                r = m - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
        System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
        System.out.println(findMin(new int[] { 11, 13, 15, 17 }));
    }
}