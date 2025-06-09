import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> numSet = new HashSet<>();
        for (int n : nums)
            numSet.add(n);

        int longest = 0;
        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                // Start of Sequence
                int length = 1;
                while (numSet.contains(n + length))
                    length++;

                longest = Math.max(length, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
    }
}