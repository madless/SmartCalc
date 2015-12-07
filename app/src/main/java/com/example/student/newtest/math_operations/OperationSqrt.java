package com.example.student.newtest.math_operations;

import com.example.student.newtest.interfaces.Operation;

/**
 * Created by student on 04.12.2015.
 */
public class OperationSqrt implements Operation {
    private double v1;

    public OperationSqrt(double v1) {
        this.v1 = v1;
    }

    @Override
    public double calculate() throws RuntimeException {
        return Math.sqrt(v1);
    }
}
