package model.element;

import model.characteristic.Coryled;
import model.characteristic.Differentiable;
import model.characteristic.Mergeable;

public class Minus extends Func implements Mergeable, Coryled {

    @Override
    public Differentiable derivate() {
        Minus minus = new Minus();
        addAllOperatedChildren(this, minus, Differentiable::derivate);
        return minus;
    }

    @Override
    public Differentiable uncoryled() {
        return null;
    }

    @Override
    public Differentiable merge() {
        return null;
    }
}
