package func;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public interface Equal {

    static <T> boolean collection(Collection<T> collection1,
                                  Collection<T> collection2) {
        if (!(collection1 instanceof List && collection2 instanceof List)) {
            return false;
        }
        List<T> list1 = new ArrayList<>(collection1);
        List<T> list2 = new ArrayList<>(collection2);
        return list1.size() == list2.size() &&
                IntStream.range(0, list1.size())
                .allMatch(i -> Objects.equals(list1.get(i), list2.get(i)));
    }
}
