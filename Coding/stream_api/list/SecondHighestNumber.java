package stream_api.list;

import java.util.Comparator;
import java.util.List;

public class SecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> intList = List.of(10, 30, 20, 50, 40);

        Integer secondHighest = intList.stream().sorted(Comparator.reverseOrder()).toList().get(1);

        System.out.println("secondHighest" + secondHighest);
    }
}
