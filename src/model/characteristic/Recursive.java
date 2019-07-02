package model.characteristic;

import java.util.Collection;

public interface Recursive extends Differentiable {
    Collection<Differentiable> getChildren();
}
