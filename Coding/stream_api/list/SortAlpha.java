package stream_api.list;

import java.util.List;

public class SortAlpha {
    public static void main(String[] args) {
        List<String> strList = List.of("banana", "apple", "ant", "cherry");

        // strList = strList.stream().sorted((a, b) -> a.charAt(0) -
        // b.charAt(0)).toList();
        strList = strList.stream().sorted().toList();

        for (String name : strList) {
            System.out.println("name " + name);
        }
    }
}
