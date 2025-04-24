import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean hasDuplicate(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            if (!numSet.contains(n)) {
                numSet.add(n);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 3 };
        int[] b = { 1, 2, 3, 4 };

        System.out.println(hasDuplicate(a));
        System.out.println(hasDuplicate(b));
    }
}