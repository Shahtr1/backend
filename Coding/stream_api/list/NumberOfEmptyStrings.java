package stream_api.list;

import java.util.List;

public class NumberOfEmptyStrings {
    public static void main(String[] args) {
        List<String> strList = List.of("a", "", "b", "", "");

        Long count = strList.stream().filter(str -> str.trim().isEmpty()).count();

        System.out.println(count);
    }
}
