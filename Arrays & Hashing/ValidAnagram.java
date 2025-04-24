import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> checkMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            checkMap.put(ch, checkMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            checkMap.put(ch, checkMap.getOrDefault(ch, 0) - 1);
        }

        for (int val : checkMap.values()) {
            if (val != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("racecar", "carrace"));
        System.out.println(isAnagram("jar", "jam"));
    }
}
