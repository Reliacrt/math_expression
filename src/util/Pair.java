package util;

import java.util.Arrays;

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A a, B b) {
        first = a;
        second = b;
    }

    public void setFirst(A a) {
        first = a;
    }

    public void setSecond(B b) {
        second = b;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Pair) {
            Pair pair = (Pair)obj;
            return first.equals(pair.first) && second.equals(pair.second);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{first, second});
    }

    @Override
    public String toString() {
        return "Pair: [" + first.toString() + ", " +
                second.toString() + "]";
    }

    public Object getAnother(Object one) {
        if (first.equals(one)) {
            return first;
        } else {
            return second;
        }
    }

    public int count(Object object) {
        int c = 0;
        if (first.equals(object)) {
            c += 1;
        }
        if (second.equals(object)) {
            c += 1;
        }
        return c;
    }
}

