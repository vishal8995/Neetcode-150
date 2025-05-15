import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    @SuppressWarnings("unchecked")
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums)
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);

        List<Integer>[] freqList = new List[nums.length + 1];
        for (int i = 0; i < freqList.length; i++)
            freqList[i] = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
            freqList[entry.getValue()].add(entry.getKey());

        int[] res = new int[k];
        int index = 0;
        for (int j = freqList.length - 1; j > 0 && index < k; j--) {
            for (int n : freqList[j]) {
                res[index++] = n;
                if (index == k)
                    return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] res = topKFrequent(new int[] { 1, 2, 2, 3, 3, 3 }, 2);
        for (int i : res)
            System.out.print(i + " ");
    }

}
