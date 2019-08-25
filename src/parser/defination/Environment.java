package parser.defination;

import util.container.DuoMap;

public class Environment<R> {
    private StreamingInput input;
    private DuoMap<Rule<R>, Integer, R> map;
    private R none;

    public Environment(StreamingInput input, DuoMap<Rule<R>, Integer, R> map, R none) {
        this.input = input;
        this.map = map;
        this.none = none;
    }

    public StreamingInput getInput() {
        return input;
    }

    public DuoMap<Rule<R>, Integer, R> getMap() {
        return map;
    }

    public R getNone() {
        return none;
    }
}
