package stream_api.list;

import java.util.List;

public class CountEven {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        long count = intList.stream().filter(num -> num % 2 == 0).count();

        System.out.println("count " + count);
    }
}
