package model.element;

import func.BranchFunc;
import model.characteristic.Coryled;
import model.characteristic.Differentiable;
import model.characteristic.Mergeable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Plus extends Func implements Mergeable, Coryled {

    @Override
    public Differentiable derivate() {
        Plus plus = new Plus();
        addAllOperatedChildren(this, plus, Differentiable::derivate);
        return plus;
    }

    @Override
    public Differentiable uncoryled() {
        Plus temp = new Plus();
        Plus plus = new Plus();
        Consumer<Differentiable> func = BranchFunc.choseToExec(Plus.class,
            p -> plus.addChildren(p.getChildren()), plus::addChild);
        addAllOperatedChildren(this, temp, Coryled::transform);
        temp.getChildren().forEach(func);
        return plus;
    }

    @Override
    public Differentiable merge() {
        Plus plus = new Plus();
        addAllOperatedChildren(this, plus, Mergeable::transform);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<Differentiable> list = (List<Differentiable>) getChildren();
        builder.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            builder.append('+');
            builder.append(list.get(i));
        }
        return builder.toString();
    }
}
