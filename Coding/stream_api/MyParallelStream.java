package stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyParallelStream<T> extends MyStream<T> {
    private final int parallelism;

    private MyParallelStream(Iterable<T> source, int parallelism) {
        super(source);
        this.parallelism = parallelism;
    }

    private static <T> MyParallelStream<T> of(List<T> list, int parallelism) {
        return new MyParallelStream<>(list, parallelism);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        ExecutorService executor = Executors.newFixedThreadPool(parallelism);

        List<Future<?>> futures = new ArrayList<>();
        List<List<T>> partitions = partitionList((List<T>) getSource(), parallelism);

        for (List<T> part : partitions) {
            futures.add(executor.submit(() -> {
                for (T item : part) {
                    Object current = item;
                    for (Function<Object, Object> op : getPipeline()) {
                        current = op.apply(current);
                        if (current == SKIP)
                            break;
                    }
                    if (current != SKIP) {
                        action.accept((T) current);
                    }
                }
            }));
        }

        waitForAll(futures);
        executor.shutdown();
    }

    public void forEachAsync(Consumer<? super T> action) {
        List<List<T>> partitions = partitionList((List<T>) getSource(), parallelism);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (List<T> part : partitions) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                for (T item : part) {
                    Object current = item;
                    for (Function<Object, Object> op : getPipeline()) {
                        current = op.apply(current);
                        if (current == SKIP)
                            break;
                    }
                    if (current != SKIP) {
                        action.accept((T) current);
                    }
                }
            });
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        // This is non-blocking internally but still waits (join()) at the end.

    }

    private void waitForAll(List<Future<?>> futures) {
        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private List<List<T>> partitionList(List<T> list, int parts) {
        List<List<T>> partitions = new ArrayList<>();
        int chunkSize = (int) Math.ceil((double) list.size() / parts);
        for (int i = 0; i < list.size(); i += chunkSize) {
            partitions.add(list.subList(i, Math.min(i + chunkSize, list.size())));
        }
        return partitions;
    }
}
