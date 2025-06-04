package stream_api.list;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RemoveNullValues {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, null, 2, null, 3);

        list.stream().filter(Objects::nonNull).toList().forEach(System.out::println);
    }
}
