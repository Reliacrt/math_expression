package parser.model.base;

import lombok.NonNull;
import lombok.Value;

public interface Type {

    Type getParent();

    String getName();

    @NonNull
    static Type build(Type parent, String name) {
        return new OneType(parent, name);
    }

    @Value
    class OneType implements Type {
        private final Type parent;
        private final String name;
    }
}
