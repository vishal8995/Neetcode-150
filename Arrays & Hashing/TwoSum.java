import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> sMap = new HashMap<>();
        int a = 0, b = 0;
        sMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (!sMap.containsKey(target - nums[i])) {
                sMap.put(nums[i], i);
            } else {
                a = sMap.get(target - nums[i]);
                b = i;
                break;
            }
        }
        return new int[] { a, b };
    }

    public static void main(String[] args) {

        int[] res = twoSum(new int[] { 3, 4, 5, 6 }, 7);
        int[] res1 = twoSum(new int[] { 4, 5, 6 }, 10);
        int[] res2 = twoSum(new int[] { 5, 5 }, 10);
        for (int i : res2)
            System.out.print(i + " ");
    }

}
