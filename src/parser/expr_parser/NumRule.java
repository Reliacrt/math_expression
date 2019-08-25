package parser.expr_parser;

import model.characteristic.Differentiable;
import model.element.Number;
import parser.defination.Environment;
import parser.defination.Rule;

import java.math.BigInteger;

public class NumRule extends Rule<Differentiable> {

    public NumRule(Environment<Differentiable> env) {
        super(env);
    }

    @Override
    protected Differentiable origMatch() {
        char[] num = new char[100];
        int i = 0;
        if (input.peek() == '-' || input.peek() == '+') {
            if (input.peek() == '-') {
                num[i++] = '-';
            }
            input.draw();
        }
        while (input.peek() <= '9' && input.peek() >= '0') {
            num[i++] = input.draw();
        }
        if (i == 0 || i == 1 && num[0] == '-') {
            return none;
        }
        jumpSpace();
        return new Number(new BigInteger(new String(num, 0, i)));
    }
}
