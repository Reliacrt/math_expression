package util.container;

import java.util.HashMap;
import java.util.Map;

public class DuoMap<K1, K2, V> {
    private Map<K2, V> nil = new HashMap<>();
    private Map<K1, Map<K2, V>> duoMap;

    public DuoMap() {
        duoMap = new HashMap<>();
    }

    public V get(K1 k1, K2 k2) {
        Map<K2, V> map = duoMap.getOrDefault(k1, nil);
        return map.get(k2);
    }

    public void put(K1 k1, K2 k2, V val) {
        if (!duoMap.containsKey(k1)) {
            duoMap.put(k1, new HashMap<>());
        }
        Map<K2, V> map = duoMap.get(k1);
        map.put(k2, val);
    }
}
