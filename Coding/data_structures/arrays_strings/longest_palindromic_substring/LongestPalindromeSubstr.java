package data_structures.arrays_strings.longest_palindromic_substring;

public class LongestPalindromeSubstr {
    public static void main(String[] args) {
        String str = "babadaasssaallloaq";
        String res = "";

        char[] chArr = str.toCharArray();

        for (int i = 0; i < chArr.length; i++) {
            // Odd length palindrome
            int start = i;
            int end = i;

            while (start > 0 && end < chArr.length - 1 && chArr[start - 1] == chArr[end + 1]) {
                start--;
                end++;
            }

            String resOdd = str.substring(start, end + 1);

            if (resOdd.length() > res.length()) {
                res = resOdd;
            }

            // Even length palindrome
            start = i;
            end = i + 1;

            while (start >= 0 && end < chArr.length && chArr[start] == chArr[end]) {
                start--;
                end++;
            }

            String resEven = str.substring(start + 1, end);

            if (resEven.length() > res.length()) {
                res = resEven;
            }

        }

        System.out.println("res =>>>> " + res);
    }
}
