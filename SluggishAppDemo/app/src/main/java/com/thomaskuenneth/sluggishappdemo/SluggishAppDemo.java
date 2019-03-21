package com.thomaskuenneth.sluggishappdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SluggishAppDemo extends Activity {

    public static final String TAG = SluggishAppDemo.class.getSimpleName();

    private boolean running;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final TextView tv = findViewById(R.id.textview);
        final CheckBox checkbox = findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> tv.setText(Boolean.toString(isChecked)));
        checkbox.setChecked(true);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            tv.setText(SluggishAppDemo.this.getString(R.string.begin));
            if (checkbox.isChecked()) {
                sleep();
            } else {
                while (running) {
                    sleep();
                }
            }
            tv.setText(SluggishAppDemo.this.getString(R.string.end));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
    }

    private void sleep() {
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            Log.e(TAG, "sleep()", e);
        }
    }
}