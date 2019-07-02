package parser.model;

import parser.model.element.TokenRegex;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    static List<TokenRegex> regexes = new ArrayList<TokenRegex>() {{
            add(new TokenRegex("([0-9])+"));
    }};
}
