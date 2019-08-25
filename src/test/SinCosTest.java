package test;

import parser.expr_parser.Entry;

public class SinCosTest {
    public static void main(String[] args) {
        System.out.println(Entry.match("11111112 + 1 * 2 + sin((1+sin(x) ^ 2)) ^ 2"));
    }
}
