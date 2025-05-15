public class ProductOfArrayExceptSelf {

    // Division Solution - Handling of Zero is essential
    // Space - O(1); Time - O(n)
    public static int[] productExceptSelf(int[] nums) {

        int prod = 1;
        int zeroCount = 0;

        for (int n : nums) {
            if (n == 0)
                zeroCount++;
            else
                prod *= n;
        }

        int[] resList = new int[nums.length];
        if (zeroCount > 1)
            return resList;

        for (int i = 0; i < resList.length; i++) {
            if (zeroCount > 0)
                resList[i] = (nums[i] == 0) ? prod : 0;
            else
                resList[i] = prod / nums[i];
        }

        return resList;
    }

    // Prefix-Suffix Array Solution
    // Space - O(n); Time - O(n)
    public static int[] productExceptSelf2(int[] nums) {

        int len = nums.length;
        int[] pre = new int[len];
        int[] suf = new int[len];
        int[] res = new int[len];

        pre[0] = 1;
        suf[len - 1] = 1;

        for (int i = 1; i < len; i++)
            pre[i] = nums[i - 1] * pre[i - 1];

        for (int j = len - 2; j >= 0; j--)
            suf[j] = nums[j + 1] * suf[j + 1];

        for (int k = 0; k < len; k++)
            res[k] = pre[k] * suf[k];

        return res;
    }

    // Suffix Solution
    // Space - O(1); Time - O(n)
    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: Fill res with prefix products
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with suffix products on the fly
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] res = productExceptSelf(new int[] { -1, 0, 1, 2, 3 });
        for (int i : res)
            System.out.print(i + " ");

        System.out.println();

        int[] res2 = productExceptSelf2(new int[] { 1, 2, 4, 6 });
        for (int i : res2)
            System.out.print(i + " ");

        System.out.println();

        int[] res3 = productExceptSelf3(new int[] { 1, 2, 4, 6 });
        for (int i : res3)
            System.out.print(i + " ");
    }
}
