package parser.defination;

public class RangeRule<R> extends Rule<R> {
    public RangeRule(Environment<R> env) {
        super(env);
    }

    @Override
    protected R origMatch() {
        return null;
    }
}
