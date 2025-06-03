package stream_api.list;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLength {
    public static void main(String[] args) {
        List<String> strList = List.of("hi", "hello", "hey", "world");

        Map<Integer, List<String>> strMap = strList.stream().collect(Collectors.groupingBy(String::length));

        System.out.println(strMap);

    }
}
