## What Is `collect()`?

`collect()` takes elements from the stream, puts them into a result container (like a `List`), and then returns that container.

In Java’s Stream API, this is done via a `Collector` object. It’s a fancy interface with methods that say:

| Part            | Role                                                              |
| --------------- | ----------------------------------------------------------------- |
| `supplier()`    | how to make a new result container (like `new ArrayList<>()`)     |
| `accumulator()` | how to add one item to that container                             |
| `finisher()`    | how to convert the container to the final result (often identity) |

```java
public <R, A> R collect(Collector<T, A, R> collector) {
    A container = collector.supplier().get();           // Step 1: Create result container
    BiConsumer<A, T> accumulator = collector.accumulator();  // Step 2: Get how to add elements
    forEach(item -> accumulator.accept(container, item));    // Step 3: Add each item
    return collector.finisher().apply(container);       // Step 4: Finalize and return result
}
```

**Line 1**: `A container = collector.supplier().get();`

- `supplier()` gives you a function to create a new empty container.
- `.get()` calls that function.
- Example: for `Collectors.toList()`, it’s like calling `new ArrayList<>()`.

You now have an empty result bucket.

**Line 2**: `BiConsumer<A, T> accumulator = collector.accumulator();`

- This gives a function that knows how to add an item to the result.
- For `toList()`, it’s like `(list, item) -> list.add(item)`.

Now you know how to fill the bucket.

**Line 3**: `forEach(item -> accumulator.accept(container, item));`

- You walk through all elements in the stream (from `source`).
- For each item, you apply the `accumulator` to add it to your container.

You’re filling your result container one item at a time.

**Line 4**: `return collector.finisher().apply(container);`

- The `finisher()` is the last step — it may convert the container.
- For most collectors, it's the **identity** function (returns the same list).
- But in `Collectors.joining()` or `Collectors.collectingAndThen()`, it could wrap it or finalize it.

You now return the final result.

## Real-Life Example

```java
List<String> names = MyStream.of(List.of("a", "b", "c"))
    .map(s -> s.toUpperCase())
    .collect(Collectors.toList());
```

## Under the hood:

1.  `supplier()` → `() -> new ArrayList<>()`
2.  `accumulator()` → `(list, item) -> list.add(item)`
3.  `finisher()` → `list -> list` (just returns the list)
