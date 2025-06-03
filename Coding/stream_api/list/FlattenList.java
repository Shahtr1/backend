package stream_api.list;

import java.util.List;

public class FlattenList {
    public static void main(String[] args) {
        List<List<Integer>> intList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5));

        intList.stream().flatMap(List::stream).toList().forEach(System.out::println);
    }
}
