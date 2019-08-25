package parser.defination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ListRule<R> extends Rule<R> {
    protected List<Rule<R>> list = new ArrayList<>();

    public ListRule(Environment<R> env) {
        super(env);
    }

    @SafeVarargs
    public final void addRuleElement(Rule<R>... rules) {
        list.addAll(Arrays.asList(rules));
    }

    protected List<R> listMatch(StreamingInput input) {
        List<R> ret = new ArrayList<>();
        for (Rule<R> rule : list) {
            if (rule.match() == none) {
                return new ArrayList<>();
            } else {
                ret.add(rule.match());
            }
        }
        return ret;
    }
}
