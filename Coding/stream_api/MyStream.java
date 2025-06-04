package stream_api;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class MyStream<T> {

    private final Iterable<T> source;
    private final List<Function<Object, Object>> pipeline = new ArrayList<>();

    protected MyStream(Iterable<T> source) {
        this.source = source;
    }

    protected Iterable<T> getSource() {
        return source;
    }

    protected List<Function<Object, Object>> getPipeline() {
        return pipeline;
    }

    public static <T> MyStream<T> of(Iterable<T> source) {
        return new MyStream<>(source);
    }

    // map
    public <R> MyStream<R> map(Function<? super T, ? extends R> mapper) {
        pipeline.add((Function<Object, Object>) mapper);
        return (MyStream<R>) this;
    }

    // filter
    public MyStream<T> filter(Predicate<? super T> predicate) {
        pipeline.add((Function<Object, Object>) o -> {
            if (predicate.test((T) o))
                return o;
            else
                return SKIP;
        });

        return this;
    }

    // foreach
    public void forEach(Consumer<? super T> action) {
        for (T item : source) {
            Object current = item;
            for (Function<Object, Object> op : pipeline) {
                current = op.apply(current);
                if (current == SKIP)
                    break;
                if (current != SKIP)
                    action.accept((T) current);
            }

        }
    }

    public <R, A> R collect(Collector<T, A, R> collector) {
        A container = collector.supplier().get(); // Step 1: Create result container
        BiConsumer<A, T> accumulator = collector.accumulator(); // Step 2: Get how to add elements
        forEach(item -> accumulator.accept(container, item)); // Step 3: Add each item
        return collector.finisher().apply(container); // Step 4: Finalize and return result
    }

    public MyStream<T> limit(int maxSize) {
        pipeline.add(new Function<Object, Object>() {

            int count = 0;

            @Override
            public Object apply(Object o) {
                if (count++ < maxSize)
                    return o;
                else
                    return SKIP;
            }

        });

        return this;
    }

    public MyStream<T> sorted(Comparator<? super T> comparator) {
        return new MyStream<>(() -> {
            List<T> temp = new ArrayList<>();
            this.forEach(temp::add);
            temp.sort(comparator);
            return temp.iterator();
        });
    }

    protected static final Object SKIP = new Object();

}
