package stream_api.list;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOccurenceInMap {
    public static void main(String[] args) {
        List<String> strList = List.of("a", "b", "a", "c", "b");

        Map<String, Long> frequencyMap = strList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frequencyMap);
    }
}
