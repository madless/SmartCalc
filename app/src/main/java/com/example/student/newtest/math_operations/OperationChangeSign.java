package com.example.student.newtest.math_operations;

import com.example.student.newtest.interfaces.Operation;

/**
 * Created by student on 04.12.2015.
 */
public class OperationChangeSign implements Operation {
    private double v;

    public OperationChangeSign(double v) {
        this.v = v;
    }

    @Override
    public double calculate() {
        return v * (-1);
    }
}
