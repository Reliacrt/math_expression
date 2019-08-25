package parser.exception;

import parser.defination.Rule;

public class MismatchException extends Exception {
    public MismatchException() {

    }

    public MismatchException(String source, int pos, Rule rule) {
        System.err.println("source: " + source);
        System.err.println("pos:" + pos);
        System.err.println("rule: " + rule);
    }
}
