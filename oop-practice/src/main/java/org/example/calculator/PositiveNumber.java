package org.example.calculator;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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
