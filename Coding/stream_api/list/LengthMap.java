package stream_api.list;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LengthMap {
    public static void main(String[] args) {
        List<String> names = List.of("banana", "apple", "ant", "cherry");

        List<Integer> lengths = names.stream()
                .map(String::length)
                .toList();

        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(Function.identity(), name -> name.length()));

        for (Map.Entry<String, Integer> entry : nameLengthMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
