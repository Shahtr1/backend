package stream_api.list;

import java.util.List;

public class FIndAllPalindromes {
    public static void main(String[] args) {
        List<String> list = List.of("madam", "apple", "civic");

        list.stream().filter(
                str -> str.equals(
                        new StringBuilder(str).reverse().toString()))
                .forEach(System.out::println);

    }
}
