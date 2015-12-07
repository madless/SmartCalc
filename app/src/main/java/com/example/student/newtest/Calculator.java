package com.example.student.newtest;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.student.newtest.enums.MessageType;
import com.example.student.newtest.interfaces.Operation;

import java.math.BigDecimal;

/**
 * Created by student on 04.12.2015.
 */
public class Calculator implements Runnable{
    Handler h;
    Operation op;
    public Calculator(Operation op, Handler h) {
        this.op = op;
        this.h = h;
    }
    @Override
    public void run() {
        try {
            Double result = op.calculate();
            Message m = h.obtainMessage(MessageType.MESSAGE_OK.ordinal(), new BigDecimal(result).setScale(6, BigDecimal.ROUND_HALF_EVEN).doubleValue());
            h.sendMessage(m);
        } catch(RuntimeException ex) {
            h.sendEmptyMessage(MessageType.MESSAGE_ERROR.ordinal());
        }
    }
}
