package stream_api.list;

import java.util.Comparator;
import java.util.List;

public class LongestString {
    public static void main(String[] args) {
        List<String> list = List.of("a", "hello", "world", "hi");

        System.out.println(list.stream().max((a, b) -> a.length() - b.length()).get());
        System.out.println(list.stream().max((Comparator.comparingInt(String::length))).get());
    }
}
