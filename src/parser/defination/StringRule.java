package parser.defination;

public abstract class StringRule<R> extends Rule<R> {
    private String str = "";

    public StringRule(Environment<R> env, String s) {
        super(env);
        str = s;
    }

    protected String strMatch(StreamingInput input) {
        StreamingInput stream = new StreamingInput(str);
        while (stream.peek() != StreamingInput.EOF) {
            if (stream.draw() != input.draw()) {
                return "";
            }
        }
        return str;
    }
}
