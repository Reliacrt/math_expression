package parser.expr_parser;

import lombok.val;
import model.characteristic.Differentiable;
import parser.defination.Environment;
import parser.defination.StreamingInput;
import util.container.DuoMap;

public class Entry {
    public static Differentiable match(String source) {
        Environment<Differentiable> env = new Environment<>(
                new StreamingInput(source), new DuoMap<>(), () -> null);
        val expr = new ExprRule(env);
        val item = new ItemRule(env);
        val factor = new FactorRule(env);
        val num = new NumRule(env);
        val expo = new ExpoRule(env);
        val sincos = new SinCosRule(env);
        val exprf = new ExprFactorRule(env);
        expr.setItem(item);
        item.setFactor(factor);
        factor.addRuleElement(num, expo, exprf);
        expo.setNum(num);
        expo.setTri(sincos);
        sincos.setFactor(factor);
        exprf.setExpr(expr);
        return expr.match();
    }
}
