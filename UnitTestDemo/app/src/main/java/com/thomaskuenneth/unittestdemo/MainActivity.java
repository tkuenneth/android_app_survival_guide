package com.thomaskuenneth.unittestdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * This class demonstrates how a lot of current Android
 * apps might look like. There is a lot of room for refactoring.
 * For example, business logic should not be mixed with ui
 * logic. Also, there are no tests.
 */
public class MainActivity extends AppCompatActivity {

    private EditText editTextGuess;
    private TextView textViewMessage;
    private RadioGroup difficulty;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        difficulty = findViewById(R.id.difficulty);
        difficulty.check(R.id.button_easy);
        difficulty.setOnCheckedChangeListener((group, checkedId) -> randomNumber());
        editTextGuess = findViewById(R.id.edittext_guess);
        textViewMessage = findViewById(R.id.textview_message);

        randomNumber();
    }

    public void handleGuess(View v) {
        int guess = Integer.parseInt(editTextGuess.getText().toString());
        boolean correct = guess(guess);
        if (correct) {
            randomNumber();
            textViewMessage.setText(R.string.correct);
        } else {
            textViewMessage.setText(R.string.wrong);
        }
        editTextGuess.setText("");
    }

    private void randomNumber() {
        number = 1 + (int) (Math.random() * getMax());
        textViewMessage.setText(R.string.guess_a_number);
    }

    private float getMax() {
        float max;
        switch (difficulty.getCheckedRadioButtonId()) {
            case R.id.button_easy:
                max = 3f;
                break;
            case R.id.button_medium:
                max = 5f;
                break;
            default:
                max = 10f;
                break;
        }
        return max;
    }

    private boolean guess(int guess) {
        return number == guess;
    }
}
