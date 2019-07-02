package model.element;

import model.characteristic.Differentiable;

import java.math.BigInteger;

public class Number implements Differentiable {
    private BigInteger value;

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
}
