package com.thomaskuenneth.debugdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WatchPointDemo demo;
    private boolean demoStarted;

    Button buttonStartStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartStop = findViewById(R.id.buttonStartStop);
        demo = new WatchPointDemo();
        demoStarted = false;
        updateStartStopButton();

        final TextView textViewResult = findViewById(R.id.textViewResult);
        final EditText editTextFactorial = findViewById(R.id.editTextFactorial);
        editTextFactorial.setOnEditorActionListener((view, actionId, event) -> {
            int f = Integer.parseInt(editTextFactorial.getText().toString());
            textViewResult.setText(Integer.toString(Factorial.factorial(f)));
            // textViewResult.setText(Integer.toString(Factorial.factorialRecursive(f)));
            return true;
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopDemo();
    }

    public void handleButtonLogClicked(View v) {
        LogDemo.logLevelDemo();
        LogDemo.isLoggableDemo();
        LogDemo.wtfDemo();
    }

    public void handleButtonStartStopClicked(View v) {
        if (demoStarted) {
            stopDemo();
        } else {
            startDemo();
        }
        updateStartStopButton();
    }

    private void updateStartStopButton() {
        buttonStartStop.setText(demoStarted ? R.string.stop : R.string.start);
    }

    private void startDemo() {
        demo.start();
        demoStarted = true;
    }

    private void stopDemo() {
        demo.stop();
        demoStarted = false;
    }
}
