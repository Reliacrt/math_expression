package model.characteristic;

public interface Differentiable {
    Differentiable derivate();

    default Differentiable uncoryledAndMerge() {
        if (this instanceof Coryled) {
            Coryled coryled = (Coryled)this;
            Differentiable mid = coryled.uncoryled();
            if (mid instanceof Mergeable) {
                Mergeable mergeable = (Mergeable)mid;
                return mergeable.merge();
            }
        }
        return this;
    }
}
