package parser.expr_parser;

import model.characteristic.Differentiable;
import model.element.Cos;
import model.element.Func;
import model.element.Sin;
import parser.defination.Environment;
import parser.defination.Rule;

public class SinCosRule extends Rule<Differentiable> {
    private Rule<Differentiable> factor;

    public SinCosRule(Environment<Differentiable> env) {
        super(env);
    }

    public void setFactor(Rule<Differentiable> factor) {
        this.factor = factor;
    }

    @Override
    protected Differentiable origMatch() {
        char c;
        Func func;
        if ((c =input.draw()) == 's') {
            if (input.draw() != 'i' || input.draw() != 'n') {
                return none;
            }
            func = new Sin();
        } else if (c == 'c') {
            if (input.draw() != 'o' || input.draw() != 's') {
                return none;
            }
            func = new Cos();
        } else {
            return none;
        }
        jumpSpace();
        if (input.draw() != '(') {
            return none;
        }
        jumpSpace();
        Differentiable atom = factor.match();
        if (atom == none) {
            return none;
        }
        jumpSpace();
        if (input.draw() != ')') {
            return none;
        }
        func.addChild(atom);
        jumpSpace();
        return func;
    }
}
