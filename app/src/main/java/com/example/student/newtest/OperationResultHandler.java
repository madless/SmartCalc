package com.example.student.newtest;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.student.newtest.enums.MessageType;

import java.lang.ref.WeakReference;

/**
 * Created by student on 04.12.2015.
 */
public class OperationResultHandler extends Handler {
    WeakReference<Activity> weakActivity;
    public OperationResultHandler(Activity a) {
        this.weakActivity = new WeakReference<Activity>(a);
    }
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Activity activity = weakActivity.get();
        if (activity != null) {
            if(msg.what == MessageType.MESSAGE_OK.ordinal()) {
                Log.d("mylog", "handler in if");
                EditText etMainField = (EditText) activity.findViewById(R.id.etMainField);
                etMainField.setText(String.valueOf(msg.obj));
            } else {
                Toast.makeText(activity, R.string.calculation_error_toast, Toast.LENGTH_SHORT).show();
            }
        }
    }
}