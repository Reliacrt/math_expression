package parser.defination;

public class StreamingInput {
    private final String source;
    private final int len;
    private int pos;
    public static final char EOF = (char)-1;

    public StreamingInput(String input) {
        source = input;
        len = source.length();
        pos = -1;
    }

    public char draw() {
        char out = peek();
        if (pos < len - 1) {
            pos += 1;
        }
        return out;
    }

    public char peek() {
        if (pos == len - 1) {
            return (char)-1;
        } else {
            return source.charAt(pos + 1);
        }
    }

    public int mark() {
        return pos;
    }

    public void reset(int position) {
        if (0 <= position && position < len) {
            pos = position;
        }
    }

    public int getLen() {
        return len;
    }

    public boolean consume(char c) {
        if (peek() == c) {
            draw();
            return true;
        } else {
            return false;
        }
    }

    public void jumpSpace() {
        while (consume(' ') || consume('\t'));
    }

    public boolean toEnd() {
        return pos == len - 1;
    }
}
