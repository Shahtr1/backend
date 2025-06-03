package stream_api.list;

import java.util.List;

public class SkipAndLimit {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 40, 50);

        list.stream().skip(2).limit(3).forEach(System.out::println);
    }
}
