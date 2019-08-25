package parser.model.base;

import lombok.NonNull;

public interface SelfValue extends Value<String> {

    default String getValue() {
        Type type = getType();
        return type.getName();
    }

    @NonNull
    static Value<String> build(Type type) {
        return new OneSelfValue(type);
    }

    @lombok.Value
    class OneSelfValue implements SelfValue {
        private Type type;
    }
}
