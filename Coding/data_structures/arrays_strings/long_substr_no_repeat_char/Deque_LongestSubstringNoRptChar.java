package data_structures.arrays_strings.long_substr_no_repeat_char;

import java.util.ArrayDeque;
import java.util.Deque;

public class Deque_LongestSubstringNoRptChar {
    public static void main(String[] args) {
        String str = "abcabcbb";

        String result = "";

        Deque<Character> deque = new ArrayDeque<>();

        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            while (deque.contains(charArr[i])) {
                deque.pollFirst();
            }
            deque.addLast(charArr[i]);

            StringBuilder sb = new StringBuilder();
            for (char c : deque) {
                sb.append(c);
            }

            if (sb.length() > result.length()) {
                result = sb.toString();
            }
        }

        System.out.println("result " + result);

    }
}
