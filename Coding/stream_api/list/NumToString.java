package stream_api.list;

import java.util.List;
import java.util.stream.Collectors;

public class NumToString {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<String> strList = intList.stream().map(String::valueOf).collect(Collectors.toList());

        for (String str : strList) {
            System.out.println("str " + str);
        }

    }
}
