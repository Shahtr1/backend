package stream_api.list;

import java.util.List;
import java.util.Map;

public class MapKeysToList {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3);

        List<String> strList = map.keySet().stream().toList();

        for (String num : strList) {
            System.out.println("num " + num);
        }
    }
}
