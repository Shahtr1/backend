package stream_api.list;

import java.util.List;
import java.util.Optional;

public class MaxNumber {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 12, 3, 14, 5, 56, 27, 8, 9);

        Optional<Integer> max = intList.stream().reduce(Integer::max);
        max.ifPresent(m -> System.out.println("max " + m));

    }
}
