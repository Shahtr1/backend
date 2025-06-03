package stream_api.list;

import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> strList = List.of("a", "b", "a", "c");

        strList.stream().distinct().toList().forEach(System.out::println);
    }
}
