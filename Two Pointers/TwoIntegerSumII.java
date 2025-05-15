
public class TwoIntegerSumII {

    public static int[] twoSum(int[] numbers, int target) {

        int[] res = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {

            if (numbers[i] + numbers[j] < target)
                i++;
            else if (numbers[i] + numbers[j] > target)
                j--;
            else {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] res = twoSum(new int[] { 2, 7, 11, 15 }, 9);
        for (int i : res)
            System.out.print(i + " ");

        System.out.println();

        int[] res2 = twoSum(new int[] { 1, 2, 3, 4 }, 3);
        for (int i : res2)
            System.out.print(i + " ");

        System.out.println();

        int[] res3 = twoSum(new int[] { 1, 2, 3, 4 }, 6);
        for (int i : res3)
            System.out.print(i + " ");

        System.out.println();

        int[] res4 = twoSum(new int[] { 1, 2, 3, 4 }, 7);
        for (int i : res4)
            System.out.print(i + " ");

    }
}
