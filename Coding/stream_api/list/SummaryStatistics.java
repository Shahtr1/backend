package stream_api.list;

import java.util.IntSummaryStatistics;
import java.util.List;

public class SummaryStatistics {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30);

        IntSummaryStatistics stats = list.stream().mapToInt(Integer::intValue).summaryStatistics();

        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Avg: " + stats.getAverage());
    }
}
