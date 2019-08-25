package model.element;

import model.characteristic.Differentiable;

public class Cos extends Func {
    @Override
    public Differentiable derivate() {
        Sin sin = new Sin();
        addAllOperatedChildren(this, sin, Differentiable::derivate);
        Multi multi = new Multi();
        multi.addChild(new Number(-1));
        multi.addChild(sin);
        return multi;
    }

    @Override
    public String toString() {
        return "cos(" + getChild(0) + ")";
    }
}
