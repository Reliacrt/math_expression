package parser.model.element;

import util.Pair;

import java.util.Scanner;

public class TokenRegex {
    private final String regex;

    public TokenRegex(String regex) {
        this.regex = regex;
    }

    public Pair<String, String> pick(String source) {
        Scanner scanner = new Scanner(source);
        String found = scanner.findInLine(regex);
        String last;
        if (found == null) {
            last = source;
        } else {
            last = source.substring(found.length());
        }
        return new Pair<>(found, last);
    }
}
