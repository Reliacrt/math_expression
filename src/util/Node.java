package util;

import lombok.NonNull;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
public class Node<T> {
    private final T value;
    private final Set<Node<T>> children = new HashSet<>();

    @NonNull
    public Node<T> addChild(Node<T> node) {
        children.add(node);
        return node;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return this.value.equals(((Node)obj).value);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public static <T> Node<T> nil() {
        return new Node<>(null);
    }
}
