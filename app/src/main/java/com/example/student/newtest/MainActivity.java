package com.example.student.newtest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.student.newtest.enums.*;
import com.example.student.newtest.interfaces.Operation;
import com.example.student.newtest.math_operations.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private EditText etMainField, etAdditionalField;
    private Button btnPlus, btnMinus, btnMult, btnDivide;
    private Button btnChangeSign, btnClear, btnBackspace, btnSeparator;
    private Button btnSqr, btnSqrt, btnLn, btnFact;
    private Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9;
    private Button btnEval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new OperationResultHandler(this);
        View.OnClickListener listener = new CalculatorOnClickListener(handler);
        bindAllViews();
        setOnClickListenerToAllButtons(listener);
    }

    private void bindAllViews() {
        etMainField = (EditText)findViewById(R.id.etMainField);
        etAdditionalField = (EditText)findViewById(R.id.etAdditionalField);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnChangeSign = (Button) findViewById(R.id.btnChangeSign);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnBackspace = (Button) findViewById(R.id.btnBackspace);
        btnSqr = (Button) findViewById(R.id.btnSqr);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);
        btnLn = (Button) findViewById(R.id.btnLn);
        btnFact = (Button) findViewById(R.id.btnFact);
        btnEval = (Button) findViewById(R.id.btnEval);
        btnNum0 = (Button) findViewById(R.id.btnNum0);
        btnNum1 = (Button) findViewById(R.id.btnNum1);
        btnNum2 = (Button) findViewById(R.id.btnNum2);
        btnNum3 = (Button) findViewById(R.id.btnNum3);
        btnNum4 = (Button) findViewById(R.id.btnNum4);
        btnNum5 = (Button) findViewById(R.id.btnNum5);
        btnNum6 = (Button) findViewById(R.id.btnNum6);
        btnNum7 = (Button) findViewById(R.id.btnNum7);
        btnNum8 = (Button) findViewById(R.id.btnNum8);
        btnNum9 = (Button) findViewById(R.id.btnNum9);
        btnSeparator = (Button) findViewById(R.id.btnSeparator);
    }
    
    private void setOnClickListenerToAllButtons(View.OnClickListener listener) {
        btnPlus.setOnClickListener(listener);
        btnMinus.setOnClickListener(listener);
        btnMult.setOnClickListener(listener);
        btnDivide.setOnClickListener(listener);
        btnChangeSign.setOnClickListener(listener);
        btnClear.setOnClickListener(listener);
        btnBackspace.setOnClickListener(listener);
        btnSqr.setOnClickListener(listener);
        btnSqrt.setOnClickListener(listener);
        btnLn.setOnClickListener(listener);
        btnFact.setOnClickListener(listener);
        btnEval.setOnClickListener(listener);
        btnNum0.setOnClickListener(listener);
        btnNum1.setOnClickListener(listener);
        btnNum2.setOnClickListener(listener);
        btnNum3.setOnClickListener(listener);
        btnNum4.setOnClickListener(listener);
        btnNum5.setOnClickListener(listener);
        btnNum6.setOnClickListener(listener);
        btnNum7.setOnClickListener(listener);
        btnNum8.setOnClickListener(listener);
        btnNum9.setOnClickListener(listener);
        btnSeparator.setOnClickListener(listener);
    }

    private class CalculatorOnClickListener implements View.OnClickListener {
        private States state;
        private Operation operation;
        private Operations operationId;
        private ExecutorService executorService;
        private double firstOperand;
        private Handler handler;
        private StringBuffer operand = new StringBuffer();
        private boolean isInteger;

        public CalculatorOnClickListener(Handler handler) {
            this.handler = handler;
            this.isInteger = true;
            this.executorService = Executors.newFixedThreadPool(1);
            this.state = States.STATE_OPERATION_NOT_SELECTED;
        }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnPlus: {
                    if(operand.length() > 0) {
                        state = States.STATE_OPERATION_SELECTED;
                        firstOperand = Double.valueOf(new String(operand));
                        etAdditionalField.setText(operand + " + ");
                        operationId = Operations.ADD;
                        operand = new StringBuffer();
                        isInteger = true;
                    }
                    break;
                }
                case R.id.btnMinus: {
                    if(operand.length() > 0) {
                        state = States.STATE_OPERATION_SELECTED;
                        firstOperand = Double.valueOf(new String(operand));
                        etAdditionalField.setText(operand + " - ");
                        operationId = Operations.SUB;
                        operand = new StringBuffer();
                        isInteger = true;
                    }
                    break;
                }
                case R.id.btnMult: {
                    if(operand.length() > 0) {
                        state = States.STATE_OPERATION_SELECTED;
                        firstOperand = Double.valueOf(new String(operand));
                        etAdditionalField.setText(operand + " * ");
                        operationId = Operations.MULT;
                        operand = new StringBuffer();
                        isInteger = true;
                    }
                    break;
                }
                case R.id.btnDivide: {
                    if(operand.length() > 0) {
                        state = States.STATE_OPERATION_SELECTED;
                        firstOperand = Double.valueOf(new String(operand));
                        etAdditionalField.setText(operand + " / ");
                        operationId = Operations.DIV;
                        operand = new StringBuffer();
                        isInteger = true;
                    }
                    break;
                }
                case R.id.btnChangeSign: {
                    if(operand.length() > 0) {
                        double value = Double.valueOf(new String(operand));
                        if (isInteger) {
                            operand = new StringBuffer(String.valueOf((long) -value));
                        } else {
                            operand = new StringBuffer(String.valueOf(-value));
                        }
                    }
                    break;
                }
                case R.id.btnClear: {
                    state = States.STATE_OPERATION_NOT_SELECTED;
                    operand = new StringBuffer();
                    etAdditionalField.setText("");
                    etMainField.setText("");
                    isInteger = true;
                    break;
                }
                case R.id.btnBackspace: {
                    if(operand.length() > 0) {
                        if(operand.charAt(operand.length() - 1) == '.'){
                            isInteger = true;
                        }
                        operand = new StringBuffer(operand.substring(0, operand.length() - 1));
                    }
                    break;
                }
                case R.id.btnSqr: {
                    if(operand.length() > 0) {
                        state = States.STATE_OPERATION_SELECTED;
                        firstOperand = Double.valueOf(new String(operand));
                        etAdditionalField.setText(operand + " ^ ");
                        operationId = Operations.SQR;
                        operand = new StringBuffer();
                        isInteger = true;
                    }
                    break;
                }
                case R.id.btnSqrt: {
                    if(operand.length() > 0) {
                        state = States.STATE_OPERATION_SELECTED;
                        firstOperand = Double.valueOf(new String(operand));
                        etAdditionalField.setText("√" + operand);
                        operationId = Operations.SQRT;
                        operand = new StringBuffer();
                        isInteger = true;
                    }
                    evaluate();
                    break;
                }
                case R.id.btnLn: {
                    if(operand.length() > 0) {
                        state = States.STATE_OPERATION_SELECTED;
                        firstOperand = Double.valueOf(new String(operand));
                        etAdditionalField.setText("ln(" + operand + ")");
                        operationId = Operations.LN;
                        operand = new StringBuffer();
                        isInteger = true;
                    }
                    evaluate();
                    break;
                }
                case R.id.btnFact: {
                    if(operand.length() > 0) {
                        state = States.STATE_OPERATION_SELECTED;
                        firstOperand = Double.valueOf(new String(operand));
                        etAdditionalField.setText(operand + "!");
                        operationId = Operations.FACT;
                        operand = new StringBuffer();
                        isInteger = true;
                    }
                    evaluate();
                    break;
                }
                case R.id.btnNum0: {
                    operand.append('0');
                    break;
                }
                case R.id.btnNum1: {
                    operand.append('1');
                    break;
                }
                case R.id.btnNum2: {
                    operand.append('2');
                    break;
                }
                case R.id.btnNum3: {
                    operand.append('3');
                    break;
                }
                case R.id.btnNum4: {
                    operand.append('4');
                    break;
                }
                case R.id.btnNum5: {
                    operand.append('5');
                    break;
                }
                case R.id.btnNum6: {
                    operand.append('6');
                    break;
                }
                case R.id.btnNum7: {
                    operand.append('7');
                    break;
                }
                case R.id.btnNum8: {
                    operand.append('8');
                    break;
                }
                case R.id.btnNum9: {
                    operand.append('9');
                    break;
                }
                case R.id.btnSeparator: {
                    if(isInteger) {
                        operand.append('.');
                        isInteger = false;
                    }
                    break;
                }
                case R.id.btnEval: {
                    evaluate();
                    break;
                }

            }
            if(state != States.STATE_OPERATION_CALCULATED) {
                etMainField.setText(operand);
            } else {
                state = States.STATE_OPERATION_NOT_SELECTED;
            }
        }
        private void evaluate() {
            if(state == States.STATE_OPERATION_SELECTED) {
                etAdditionalField.setText(etAdditionalField.getText().toString() + operand + " =");
                double secondOperand = 0;
                if(operand.length() > 0) {
                    secondOperand = Double.valueOf(new String(operand));
                }
                operand = new StringBuffer();
                switch (operationId) {
                    case ADD: {
                        operation = new OperationAdd(firstOperand, secondOperand);
                        break;
                    }
                    case SUB: {
                        operation = new OperationSub(firstOperand, secondOperand);
                        break;
                    }
                    case MULT: {
                        operation = new OperationMult(firstOperand, secondOperand);
                        break;
                    }
                    case DIV: {
                        operation = new OperationDiv(firstOperand, secondOperand);
                        break;
                    }
                    case SQR: {
                        operation = new OperationSqr(firstOperand, secondOperand);
                        break;
                    }
                    case SQRT: {
                        operation = new OperationSqrt(firstOperand);
                        break;
                    }
                    case LN: {
                        operation = new OperationLn(firstOperand);
                        break;
                    }
                    case FACT: {
                        operation = new OperationFact(firstOperand);
                        break;
                    }
                }
                Calculator calculator = new Calculator(operation, handler);
                executorService.execute(calculator);
                state = States.STATE_OPERATION_CALCULATED;
            }
        }
    }


}
