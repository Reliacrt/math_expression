package util.container;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CachedMap<K, V> {
    private Map<Function<K, V>, Map<K, V>> funcMap;

    public CachedMap() {
        this.funcMap = new HashMap<>();
    }

    @NonNull
    public void putFunc(Function<K, V> func) {
        funcMap.put(func, new HashMap<>());
    }

    @NonNull
    public V get(Function<K, V> func, K key) {
        Map<K, V> map = funcMap.getOrDefault(func, new HashMap<>());
        if (!map.containsKey(key)) {
            map.put(key, func.apply(key));
        }
        return map.get(key);
    }
}
