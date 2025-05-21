import java.util.HashMap;

public class TwoSum {

    // public static int[] twoSum(int[] nums, int target) {

    // Map<Integer, Integer> sMap = new HashMap<>();
    // int a = 0, b = 0;
    // sMap.put(nums[0], 0);
    // for (int i = 1; i < nums.length; i++) {
    // if (!sMap.containsKey(target - nums[i])) {
    // sMap.put(nums[i], i);
    // } else {
    // a = sMap.get(target - nums[i]);
    // b = i;
    // break;
    // }
    // }
    // return new int[] { a, b };
    // }

    // Cleaner
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }

            prevMap.put(num, i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {

        int[] res = twoSum(new int[] { 3, 4, 5, 6 }, 7);
        for (int i : res)
            System.out.print(i + " ");

        System.out.println();

        int[] res1 = twoSum(new int[] { 4, 5, 6 }, 10);
        for (int i : res1)
            System.out.print(i + " ");

        System.out.println();

        int[] res2 = twoSum(new int[] { 5, 5 }, 10);
        for (int i : res2)
            System.out.print(i + " ");
    }

}
