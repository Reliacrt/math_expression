package parser.defination;

import util.container.DuoMap;

public abstract class Rule<R> {
    private DuoMap<Rule<R>, Integer, R> cache;
    protected StreamingInput input;
    protected R none;
    protected static Rule instance;

    public Rule(Environment<R> env) {
        this.cache = env.getMap();
        this.input = env.getInput();
        this.none = env.getNone();
    }

    public R match() {
        int pos = input.mark();
        if (cache.get(this, pos) == null) {
            cache.put(this, pos, memMatch());
        }
        return cache.get(this, pos);
    }

    protected abstract R origMatch();

    protected void jumpSpace() {
        input.jumpSpace();
    }

    private R memMatch() {
        int pos = input.mark();
        R ret = origMatch();
        if (ret == null || ret == none) {
            input.reset(pos);
        }
        return ret;
    }
}
