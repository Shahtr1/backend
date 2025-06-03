package stream_api.list;

import java.util.List;

public class CommonElementsInTwoList {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(2, 3, 4);

        list1.stream().filter(list2::contains).distinct().toList();
    }
}
