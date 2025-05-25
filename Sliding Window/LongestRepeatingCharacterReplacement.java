import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {

        int l = 0;
        int maxRepeat = 0; // maxF -> Neetcode
        int maxLength = 0; // res -> Neetcode
        HashMap<Character, Integer> count = new HashMap<>();

        int len = s.length();

        // Increase size of window until the nonRepeat is > k
        for (int r = 0; r < len; r++) {

            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c, 0) + 1);

            maxRepeat = Math.max(count.get(c), maxRepeat);
            // The value which should be <= k
            int nonRepeat = ((r - l + 1) - maxRepeat); // Window Size - Max Repeat

            // If non repeat is greater than k, reduce window size from the left
            if (nonRepeat > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            // Max Length of window size that can have consecutive repeating characters with
            // k substitutions for k characters; Calculated at every pass
            maxLength = Math.max(maxLength, (r - l + 1));
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(characterReplacement("XYYX", 2));
        System.out.println(characterReplacement("AAABABB", 1));
    }
}
