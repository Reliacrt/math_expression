package model.element;

import model.characteristic.Differentiable;

public class Sin extends Func {
    @Override
    public Differentiable derivate() {
        Cos cos = new Cos();
        addAllOperatedChildren(this, cos, Differentiable::derivate);
        return cos;
    }

    @Override
    public String toString() {
        return "sin(" + getChild(0) + ")";
    }
}
