package com.example.student.newtest.math_operations;

import com.example.student.newtest.interfaces.Operation;

/**
 * Created by student on 04.12.2015.
 */
public class OperationFact implements Operation {
    private double x1, x2;

    public OperationFact(double x) {
        this.x1 = Math.floor(x);
        this.x2 = x - x1;
    }

    @Override
    public double calculate() {
        double degree = Math.log(getFactForInt(x1)) + (x2 * Math.log(x1 + 1));
        return Math.exp(degree);
    }

    public double getFactForInt(double n){
        double res = 1;
        for(int i = 1; i < n; i++) {
            res *= i;
        }
        return res;
    }
}
