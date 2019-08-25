package parser.model.base;

import lombok.NonNull;

public interface Value<V> {

    Type getType();

    V getValue();

    @NonNull
    static <V> Value<V> build(Type type, V value) {
        return new OneValue<>(type, value);
    }

    @lombok.Value
    class OneValue<V> implements Value<V> {
        private Type type;
        private V value;
    }
}
