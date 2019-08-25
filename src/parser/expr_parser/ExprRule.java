package parser.expr_parser;

import model.characteristic.Differentiable;
import model.element.Func;
import model.element.Multi;
import model.element.Number;
import model.element.Plus;
import parser.defination.Environment;
import parser.defination.Rule;

public class ExprRule extends Rule<Differentiable> {
    private Rule<Differentiable> item;

    public ExprRule(Environment<Differentiable> env) {
        super(env);
    }

    public void setItem(Rule<Differentiable> item) {
        this.item = item;
    }

    @Override
    protected Differentiable origMatch() {
        Func plus = new Plus();
        Func ret = plus;
        if (input.peek() == '-' || input.peek() == '+') {
            if (input.draw() == '-') {
                ret = new Multi();
                ret.addChild(Number.MINUS_ONE);
                ret.addChild(plus);
            }
            jumpSpace();
        }
        Differentiable temp = item.match();
        if (temp == none) {
            return none;
        }
        plus.addChild(temp);
        jumpSpace();
        while (input.peek() == '-' || input.peek() == '+') {
            char c = input.draw();
            jumpSpace();
            temp = item.match();
            if (temp == none) {
                return none;
            }
            if (c == '-') {
                Func t = new Multi();
                t.addChild(Number.MINUS_ONE);
                t.addChild(temp);
                temp = t;
            }
            plus.addChild(temp);
            jumpSpace();
        }
        return ret;
    }
}
