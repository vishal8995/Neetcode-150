import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {

            // Since array is sorted, the numbers following this would be greater than 0
            // There would be no possible solutions anymore
            if (nums[i] > 0)
                break;

            // To navigate duplicates, if a number is same as its predecessor
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            /*
             * We use two pointers ahead of nums[i] because the array is sorted, and all
             * combinations with elements before i were already considered in earlier
             * iterations. This ensures that each unique triplet is checked exactly once
             * without redundancy.
             */
            int l = i + 1, r = len - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < 0)
                    l++;
                else if (nums[i] + nums[l] + nums[r] > 0)
                    r--;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // This step is to again navigate duplicates based the fact that if same value
                    // for l was considered
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                    // Another check for right can also be placed, but it isn't essential as the
                    // "else if" case above checks for the scenario and takes care of r. That is
                    // even if nums[r] is duplicate the case where sum > 0 ic checked, the movement
                    // of r is taken care of.

                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        List<List<Integer>> list = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });

        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            List<Integer> inner = list.get(i);
            System.out.print("[");
            for (int j = 0; j < inner.size(); j++) {
                System.out.print(inner.get(j));
                if (j < inner.size() - 1)
                    System.out.print(",");
            }
            System.out.print("]");
            if (i < list.size() - 1)
                System.out.print(",");
        }
        System.out.println("]");
    }

}
