package model.element;

import model.characteristic.Differentiable;

import java.math.BigInteger;

public class Expo extends Func {

    @Override
    public Differentiable derivate() {
        if (this.size() == 2) {
            if (this.getChild(1) instanceof Number) {
                Expo expo = new Expo();
                Number temp = (Number) this.getChild(1);
                Differentiable child1 = this.getChild(0);
                Differentiable child2 =
                        new Number(temp.getValue().subtract(BigInteger.ONE));
                expo.addChild(child1);
                expo.addChild(child2);
                Multi multi = new Multi();
                multi.addChild(temp);
                multi.addChild(expo);
                return multi;
            }
        }
        return this;
    }



    @Override
    public String toString() {
        return getChild(0) + "^" + getChild(1);
    }
}
