package parser.expr_parser;

import model.characteristic.Differentiable;
import model.element.Expo;
import model.element.Func;
import model.element.Variable;
import parser.defination.Environment;
import parser.defination.Rule;

public class ExpoRule extends Rule<Differentiable> {
    private Rule<Differentiable> tri;
    private Rule<Differentiable> num;

    public ExpoRule(Environment<Differentiable> env) {
        super(env);
    }

    public void setNum(Rule<Differentiable> num) {
        this.num = num;
    }

    public void setTri(Rule<Differentiable> tri) {
        this.tri = tri;
    }

    @Override
    protected Differentiable origMatch() {
        Differentiable bottom;
        if (input.consume('x')) {
            bottom = new Variable();
        } else {
            bottom = tri.match();
        }
        if (bottom == none) {
            return none;
        }
        jumpSpace();
        if (input.peek() != '^') {
            return bottom;
        } else {
            input.draw();
            jumpSpace();
            Differentiable number = num.match();
            if (number == none) {
                return none;
            }
            Func ret = new Expo();
            ret.addChild(bottom);
            ret.addChild(number);
            jumpSpace();
            return ret;
        }
    }
}
