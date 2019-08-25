package model.element;

import model.characteristic.Differentiable;

public class Variable implements Differentiable {

    public Variable() { }

    @Override
    public Differentiable derivate() {
        return new Number(1);
    }

    @Override
    public String toString() {
        return "x";
    }
}
