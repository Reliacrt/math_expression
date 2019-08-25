package model.element;

import model.characteristic.Differentiable;

import java.math.BigInteger;

public class Number implements Differentiable {
    private BigInteger value;
    public static final Differentiable MINUS_ONE = new Number(-1);
    public static final Differentiable ONE = new Number(1);

    public Number(BigInteger value) {
        if (value == null) {
            throw new NullPointerException();
        }
        this.value = value;
    }

    public Number(String string) {
        value = new BigInteger(string);
    }

    public Number(long val) {
        value = BigInteger.valueOf(val);
    }

    public BigInteger getValue() {
        return value;
    }

    @Override
    public Differentiable derivate() {
        return new Number(0);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
