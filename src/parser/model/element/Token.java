package parser.model.element;

public class Token {
    private final TokenRegex regex;
    private final String material;

    public Token(TokenRegex regex, String material) {
        this.regex = regex;
        this.material = material;
    }
}
