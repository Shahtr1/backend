package stream_api.list;

import java.util.List;

public class CommaSeparatedString {
    public static void main(String[] args) {
        List<String> strList = List.of("a", "", "b", "");

        List<String> res = strList.stream().filter(str -> !str.trim().isEmpty()).toList();

        for (String resStr : res) {
            System.out.println(resStr);
        }
    }
}
