package parser.expr_parser;

import model.characteristic.Differentiable;
import parser.defination.Environment;
import parser.defination.Rule;

public class ExprFactorRule extends Rule<Differentiable> {
    private Rule<Differentiable> expr;

    public ExprFactorRule(Environment<Differentiable> env) {
        super(env);
    }

    public void setExpr(Rule<Differentiable> expr) {
        this.expr = expr;
    }

    @Override
    protected Differentiable origMatch() {
        Differentiable ret;
        if (input.draw() != '(') {
            return none;
        }
        jumpSpace();
        if ((ret = expr.match()) == none) {
            return none;
        }
        jumpSpace();
        if (input.draw() != ')') {
            return none;
        }
        jumpSpace();
        return ret;
    }
}
