package stream_api.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentWord {
    public static void main(String[] args) {
        String str = "the cat and the dog";

        List<String> list = Arrays.asList(str.split(" "));

        String res = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().max(Map.Entry.comparingByValue()).get()
                .getKey();

        System.out.println("res " + res);

    }
}
