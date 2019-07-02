package func;

import java.util.Map;
import java.util.function.Consumer;

public interface CountFunc {

    static <T> Consumer<T> addCount(
            Map<T, Integer> map) {
        return addCount(map, e -> { });
    }

    static <T> Consumer<T> addCount(
            Map<T, Integer> map, Consumer<T> consumer) {
        return i -> {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
                consumer.accept(i);
            }
        };
    }

    static <T> Consumer<T> minusCount(
            Map<T, Integer> map) {
        return minusCount(map, e -> { });
    }

    static <T> Consumer<T> minusCount(
            Map<T, Integer> map, Consumer<T> consumer) {
        return i -> {
            if (!map.containsKey(i)) {
                throw new RuntimeException();
            }
            if (map.get(i).equals(1)) {
                map.remove(i);
                consumer.accept(i);
            } else {
                map.put(i, map.get(i) - 1);
            }
        };
    }
}
