package func;

import java.util.function.Consumer;

public interface BranchFunc {

    static <T extends E, E> Consumer<E> choseToExec(
            Class<T> typeClass, Consumer<T> isType, Consumer<E> isNotType) {
        return e -> {
            if (typeClass.isInstance(e)) {
                isType.accept((T) e);
            } else {
                isNotType.accept(e);
            }
        };
    }
}
