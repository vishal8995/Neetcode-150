
public class FibonacciNumber {

    public static int[] fibonacciDP(int n) {

        if (n == 0)
            return new int[0];
        if (n == 1)
            return new int[] { 1 };

        int[] res = new int[n];
        int one = 1, two = 1;
        res[0] = one;
        res[1] = two;

        for (int i = 2; i < n; i++) {

            int temp = one;
            one = one + two;
            two = temp;

            res[i] = one;
        }
        return res;

    }

    public static void main(String[] args) {

        int[] nums = fibonacciDP(7);
        for (int n : nums)
            System.out.print(n + "->");
    }

}
