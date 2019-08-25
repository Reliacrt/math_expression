package parser.model.characteristic;

import parser.model.element.Token;

public interface Reducible {

    static enum Type { TOKEN, UNIT }

    static Type getType(Reducible reducible) {
        if (reducible instanceof Token) {
            return Type.TOKEN;
        } else {
            return Type.UNIT;
        }
    }
}
