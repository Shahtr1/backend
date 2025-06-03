package stream_api.list;

import java.util.List;

public class Product {
    public static void main(String[] args) {
        List<Integer> intList = List.of(2, 3, 4);

        int res = intList.stream().reduce(Math::multiplyExact).get();

        System.out.println("res " + res);
    }
}
