package com.example.student.newtest.math_operations;

import com.example.student.newtest.interfaces.Operation;

/**
 * Created by student on 04.12.2015.
 */
public class OperationSqr implements Operation {
    private double v1, v2;

    public OperationSqr(double v1, double v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public double calculate() {
        double result = 1;
        for(int i = 1; i < v2; i++) {
            result *= v1;
        }
        return result;
    }
}
