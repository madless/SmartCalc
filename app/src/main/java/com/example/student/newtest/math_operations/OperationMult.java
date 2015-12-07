package com.example.student.newtest.math_operations;

import com.example.student.newtest.interfaces.Operation;

/**
 * Created by student on 04.12.2015.
 */
public class OperationMult implements Operation {
    private double v1, v2;

    public OperationMult(double v1, double v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public double calculate() {
        return v1 * v2;
    }
}
