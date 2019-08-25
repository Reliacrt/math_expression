package test;

import model.characteristic.Differentiable;
import parser.defination.Environment;
import parser.defination.Rule;
import parser.defination.StreamingInput;
import parser.expr_parser.NumRule;
import util.container.DuoMap;

import java.math.BigInteger;

public class NumRuleTest {
    public static void main(String[] args) {
        StreamingInput input = new StreamingInput("  -12345      ");
        Environment<Differentiable> env = new Environment<>(input,
                new DuoMap<>(), () -> null);
        Rule<Differentiable> rule = new NumRule(env);
        System.out.println(rule.match());
        System.out.println(input.getLen());
        System.out.println(input.mark());
    }
}
