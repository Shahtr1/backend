package stream_api.list;

import java.util.List;
import java.util.stream.Collectors;

public class PartitionEvenOdd {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4);
        System.out.println(list.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0)));
    }
}
