package parser.expr_parser;

import model.characteristic.Differentiable;
import parser.defination.Environment;
import parser.defination.ListRule;
import parser.defination.Rule;

public class FactorRule extends ListRule<Differentiable> {

    public FactorRule(Environment<Differentiable> env) {
        super(env);
    }

    protected Differentiable origMatch() {
        Differentiable diff;
        for (Rule<Differentiable> rule : list) {
            if ((diff = rule.match()) != none) {
                return diff;
            }
        }
        return none;
    }
}
