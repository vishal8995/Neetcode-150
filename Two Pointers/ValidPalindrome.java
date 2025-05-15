public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        String input = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0, j = input.length() - 1;

        while (i <= j) {
            if (input.charAt(i) != input.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));
        System.out.println(isPalindrome("tab a cat"));
    }
}
