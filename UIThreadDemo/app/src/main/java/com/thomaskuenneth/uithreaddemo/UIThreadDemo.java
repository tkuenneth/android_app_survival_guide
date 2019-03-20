package com.thomaskuenneth.uithreaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class UIThreadDemo extends Activity {

    public static final String TAG = UIThreadDemo.class.getSimpleName();

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
            tv.setText(UIThreadDemo.this.getString(R.string.begin));
            if (checkbox.isChecked()) {
                try {
                    Thread.sleep(3500);
                    if (Math.random() > .5) {
                        String s = null;
                        int l = s.length();
                        if (l == 0) {
                            Log.wtf(TAG, "Should never be printed ;-)");
                        }
                    }
                } catch (InterruptedException e) {
                    Log.e(TAG, "sleep()", e);
                }
            } else {
                while (true) ;
            }
            tv.setText(UIThreadDemo.this.getString(R.string.end));
        });
    }
}
