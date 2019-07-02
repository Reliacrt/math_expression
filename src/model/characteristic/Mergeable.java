package model.characteristic;

public interface Mergeable extends Recursive {
    Differentiable merge();

    static Differentiable transform(Differentiable diff) {
        if (diff instanceof Mergeable) {
            Mergeable mergeable = (Mergeable) diff;
            return mergeable.merge();
        } else {
            return diff;
        }
    }
}
