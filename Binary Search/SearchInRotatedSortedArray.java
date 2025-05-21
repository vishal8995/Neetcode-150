public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target)
                return m;

            if (nums[l] <= nums[m]) {

                if (target > nums[m] || target < nums[l])
                    l = m + 1;
                else
                    r = m - 1;

            } else {

                if (target > nums[r] || target < nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            }

        }

        return -1;

    }

    public static void main(String[] args) {

        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(search(new int[] { 3, 4, 5, 6, 1, 2 }, 1));
    }

}
