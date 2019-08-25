package parser.expr_parser;

import model.characteristic.Differentiable;
import model.element.Func;
import model.element.Multi;
import model.element.Number;
import parser.defination.Environment;
import parser.defination.Rule;

public class ItemRule extends Rule<Differentiable> {
    private Rule<Differentiable> factor;

    public ItemRule(Environment<Differentiable> env) {
        super(env);
    }

    public void setFactor(Rule<Differentiable> factor) {
        this.factor = factor;
    }

    @Override
    protected Differentiable origMatch() {
        Func ret = new Multi();
        jumpSpace();
        if (input.peek() == '-' || input.peek() == '+') {
            if (input.draw() == '-') {
                ret.addChild(Number.MINUS_ONE);
            }
            jumpSpace();
        }
        Differentiable temp = factor.match();
        if (temp == none) {
            return none;
        }
        ret.addChild(temp);
        jumpSpace();
        while (input.consume('*')) {
            jumpSpace();
            temp = factor.match();
            if (temp == none) {
                return none;
            }
            ret.addChild(temp);
            jumpSpace();
        }
        return ret;
    }
}
