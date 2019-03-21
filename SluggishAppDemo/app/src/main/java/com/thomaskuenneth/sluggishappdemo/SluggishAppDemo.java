package com.thomaskuenneth.sluggishappdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SluggishAppDemo extends Activity {

    public static final String TAG = SluggishAppDemo.class.getSimpleName();

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
                BusinessLogic.doComplexStuff();
            } else {
                BusinessLogic.doVeryComplexStuff();
            }
            tv.setText(SluggishAppDemo.this.getString(R.string.end));
        });
    }
}