package model.characteristic;

public interface Coryled extends Recursive {
    Differentiable uncoryled();

    static Differentiable transform(Differentiable diff) {
        if (diff instanceof Coryled) {
            Coryled coryled = (Coryled)diff;
            return coryled.uncoryled();
        } else {
            return diff;
        }
    }
}
