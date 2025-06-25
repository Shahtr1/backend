package data_structures.arrays_strings.long_substr_no_repeat_char;

import java.util.HashMap;
import java.util.Map;

public class HashMap_LongestSubstringNoRptChar {
    public static void main(String[] args) {
        String str = "abcabcbb";

        String result = "";

        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int maxLen = 0;

        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char ch = charArr[i];

            if (map.containsKey(ch) && map.get(ch) >= start) {
                if (i - start > maxLen) {
                    maxLen = i - start;
                    result = str.substring(start, i);
                }
                start = map.get(ch) + 1;
            }

            map.put(ch, i);
        }

        // Final window check
        if (charArr.length - start > maxLen)
            result = str.substring(start);

        System.out.println("result " + result);

    }
}
