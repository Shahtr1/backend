package stream_api.list;

import java.util.List;
import java.util.stream.Stream;

public class MergeTwoLists {
    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 2);
        List<Integer> l2 = List.of(3, 4);

        Stream.concat(l1.stream(), l2.stream()).toList();
    }
}
