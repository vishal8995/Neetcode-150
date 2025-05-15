import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

    // Naive Solution - Will fail if strings themselves have space.
    // public static String encode(List<String> strs) {
    // String res = new String();
    // for (String s : strs) {
    // res += s + " ";
    // }
    // return res;
    // }

    // public static List<String> decode(String str) {

    // String[] arr = str.split(" ");
    // List<String> res = new ArrayList<>();
    // for (int i = 0; i < arr.length; i++) {
    // res.add(arr[i]);
    // }
    // return res;
    // }

    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }

    public static List<String> decode(String str) {

        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            res.add(str.substring(j, j + len)); // safe substring
            i = j + len;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = encode(Arrays.asList("lint", "code", "love", "you"));
        List<String> res = decode(str);
        for (String s : res)
            System.out.print("\"" + s + "\"" + ", ");
    }
}
