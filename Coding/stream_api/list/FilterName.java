package stream_api.list;

import java.util.List;
import java.util.stream.Collectors;

public class FilterName {
    public static void main(String[] args) {
        List<String> strList = List.of("Alice", "Bob", "Anna");

        strList = strList.stream().filter((name) -> name.startsWith("A")).collect(Collectors.toList());

        for (String name : strList) {
            System.out.println("name " + name);
        }
    }
}
