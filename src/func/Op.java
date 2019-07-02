package func;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Op {

    static <E1, E2> Collection<E2> mapToSet(Collection<E1> source,
                                            Function<E1, E2> transfer) {
        Collection<E2> collection = new HashSet<>();
        map(source, collection, transfer);
        return collection;
    }

    static <E1, E2> Collection<E2> mapToList(Collection<E1> source,
                                             Function<E1, E2> transfer) {
        Collection<E2> collection = new ArrayList<>();
        map(source, collection, transfer);
        return collection;
    }

    static <E1, E2> void map(Collection<E1> source,
                             Collection<E2> target,
                             Function<E1, E2> transfer) {
        source.stream().map(transfer).forEach(target::add);
    }

    static <E1> Collection<E1> filter(Collection<E1> source,
                                      Predicate<E1> predicate) {
        Collection<E1> collection = new ArrayList<>();
        filter(source, collection, predicate);
        return collection;
    }

    static <E1> void filter(Collection<E1> source,
                            Collection<E1> target,
                            Predicate<E1> predicate) {
        source.stream().filter(predicate).forEach(target::add);
    }

    static <E1, U extends Comparable<? super U>> E1
            max(Collection<E1> source,
                Function<E1, U> transfer,
                E1 element) {
        return source.stream().max(Comparator.comparing(transfer))
                .orElse(element);
    }

    static <E1, U extends Comparable<? super U>> E1
            min(Collection<E1> source,
                Function<E1, U> transfer,
                E1 element) {
        return source.stream().min(Comparator.comparing(transfer))
                .orElse(element);
    }
}
