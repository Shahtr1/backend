package stream_api.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllDuplicates {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 2, 4, 1);

        Set<Integer> seen = new HashSet<>();

        List<Integer> duplicates = intList.stream()
                .filter(num -> !seen.add(num))
                .distinct()
                .toList();

        for (Integer num : duplicates) {
            System.out.println("num " + num);
        }
    }
}
