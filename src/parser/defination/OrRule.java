package parser.defination;

import java.util.ArrayList;
import java.util.List;

public class OrRule<R> extends ListRule<R> {
    private List<Rule<R>> children;

    public OrRule(Environment<R> env) {
        super(env);
        children = new ArrayList<>();
    }

    @Override
    protected R origMatch() {
        for (Rule<R> rule : children) {
            if (rule.match() != none) {
                return rule.match();
            }
        }
        return none;
    }

    protected List<Rule<R>> getChildren() {
        return children;
    }
}
