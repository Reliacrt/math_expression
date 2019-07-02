package model.element;

import model.characteristic.Differentiable;
import model.characteristic.Recursive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

abstract class Func implements Differentiable, Recursive {
    private List<Differentiable> children;

    Func() {
        children = new ArrayList<>();
    }

    @Override
    public Collection<Differentiable> getChildren() {
        return children;
    }

    public void addChild(Differentiable child) {
        children.add(child);
    }

    public void addChildren(Collection<Differentiable> collection) {
        children.addAll(collection);
    }

    void addAllOperatedChildren(
            Func source, Func target,
            Function<Differentiable, Differentiable> function) {
        for (Differentiable diff : source.getChildren()) {
            target.addChild(function.apply(diff));
        }
    }

    int size() {
        return children.size();
    }

    Differentiable getChild(int index) {
        return children.get(index);
    }
}
