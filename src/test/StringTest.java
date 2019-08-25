package test;

public class StringTest {
    public static void main(String[] args) {
        char[] s = new char[100];
        s[0] = '0';
        s[1] = '2';
        System.out.println(new String(s));
    }
}
