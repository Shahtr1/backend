package stream_api.list;

import java.util.List;

public class SumOfNumbers {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int sum = intList.stream().reduce(0, Integer::sum);
        // or
        // int sum = intList.stream().mapToInt(Integer::intValue).sum();

        System.out.println("sum " + sum);
    }
}
