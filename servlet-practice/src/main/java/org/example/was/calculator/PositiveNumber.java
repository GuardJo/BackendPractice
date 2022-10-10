package org.example.was.calculator;

public class PositiveNumber {
    private int number;

    public PositiveNumber(int number) {
        validate(number);
        this.number = number;
    }

    private boolean validate(int number) {
        if (isNegativeNumber(number)) {
            throw new IllegalArgumentException("Can not calculate number under zero");
        }
        return true;
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int getNumber() {
        return this.number;
    }
}
