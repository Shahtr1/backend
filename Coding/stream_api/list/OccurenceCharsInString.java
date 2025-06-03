package stream_api.list;

import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceCharsInString {
    public static void main(String[] args) {
        String str = "hello";

        System.out.println(str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
