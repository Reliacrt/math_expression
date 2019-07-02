package model.element;

import model.characteristic.Coryled;
import model.characteristic.Differentiable;
import model.characteristic.Mergeable;

import java.util.Collection;

public class Multi extends Func implements Mergeable, Coryled {
    @Override
    public Differentiable derivate() {
        Plus plus = new Plus();
        Collection<Differentiable> children = getChildren();
        for (Differentiable differentiable : children) {
            Multi multi = new Multi();
            for (Differentiable diff : children) {
                if (diff == differentiable) {
                    multi.addChild(diff.derivate());
                } else {
                    multi.addChild(diff);
                }
            }
            plus.addChild(multi);
        }
        return plus;
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
