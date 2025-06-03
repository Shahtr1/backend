package stream_api.list;

import java.util.List;

public class GreaterThan {
    public static void main(String[] args) {
        List<Integer> intList = List.of(22, 45, 130, 33, 170);

        Boolean bool = intList.stream().anyMatch(num -> num > 100);
        System.out.println("bool " + bool);

    }
}
