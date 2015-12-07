package com.example.student.newtest.math_operations;

import com.example.student.newtest.interfaces.Operation;

/**
 * Created by student on 04.12.2015.
 */
public class OperationLn implements Operation {
    private double v;

    public OperationLn(double v) {
        this.v = v;
    }

    @Override
    public double calculate() {
        return Math.log(v);
    }
}
