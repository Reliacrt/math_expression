package util.container;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MulValMap<K, V> {
    private Map<K, Collection<V>> map;
    private Supplier<Collection<V>> supplier;

    public MulValMap(Supplier<Collection<V>> supplier) {
        this.supplier = supplier;
        this.map = new HashMap<>();
    }

    public void put(K key, V value) {
        if (!map.containsKey(key)) {
            map.put(key, supplier.get());
        }
        map.get(key).add(value);
    }

    public Collection<V> get(K key) {
        return map.getOrDefault(key, supplier.get());
    }
}
