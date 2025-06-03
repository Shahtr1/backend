package stream_api.list;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UniqueElements {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 12, 3, 14, 12, 56, 27, 1, 9);

        intList = intList.stream().distinct().collect(Collectors.toList());

        for (int num : intList) {
            System.out.println("num " + num);
        }
    }
}
