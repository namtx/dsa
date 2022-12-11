package dev.namtx.adventofcode2022.day11;

import java.math.BigInteger;
import java.util.List;

public class Monkey {
    List<Long> items;
    String operation;
    int monkeyToThrowToIfTestSuccess;
    int monkeyToThrowToIfTestFail;
    long testDivider;
    String operand;
    String operator;

    public Monkey() {}

    long operate(long currentWorryLevel) {
        long operandLong;
        if (operand.equals("old")) {
            operandLong = currentWorryLevel;
        } else {
            operandLong = Long.parseLong(operand);
        }
        switch (operator) {
            case "*":
                return currentWorryLevel*(operandLong);
            case "+":
                return currentWorryLevel + operandLong;
            case "-":
                return currentWorryLevel - operandLong;
            default:
                return 0;
        }
    }
}
