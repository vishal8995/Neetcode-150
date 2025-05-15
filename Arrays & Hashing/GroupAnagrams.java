import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> gMap = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            gMap.computeIfAbsent(Arrays.toString(count), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(gMap.values());
    }

    public static void main(String[] args) {
        List<List<String>> res = groupAnagrams(new String[] { "act", "pots", "tops", "cat", "stop", "hat" });

        System.out.print("[");
        for (int i = 0; i < res.size(); i++) {
            List<String> inner = res.get(i);
            System.out.print("[");
            for (int j = 0; j < inner.size(); j++) {
                System.out.print("\"" + inner.get(j) + "\"");
                if (j < inner.size() - 1)
                    System.out.print(", ");
            }
            System.out.print("]");
            if (i < res.size() - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
