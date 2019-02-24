package com.thomaskuenneth.unittestdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGuess;
    private TextView textViewMessage;
    private RadioGroup difficulty;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();

        difficulty = findViewById(R.id.difficulty);
        difficulty.check(R.id.button_easy);
        difficulty.setOnCheckedChangeListener((group, checkedId) -> setup());
        editTextGuess = findViewById(R.id.edittext_guess);
        textViewMessage = findViewById(R.id.textview_message);

        setup();
    }

    public void handleGuess(View v) {
        int guess = Integer.parseInt(editTextGuess.getText().toString());
        boolean correct = game.guess(guess);
        if (correct) {
            setup();
            textViewMessage.setText(R.string.correct);
        } else {
            textViewMessage.setText(R.string.wrong);
        }
        editTextGuess.setText("");
    }

    private void setup() {
        switch (difficulty.getCheckedRadioButtonId()) {
            case R.id.button_easy:
                game.setup(Game.Difficulty.EASY);
                break;
            case R.id.button_medium:
                game.setup(Game.Difficulty.MEDIUM);
                break;
            case R.id.button_hard:
                game.setup(Game.Difficulty.HARD);
                break;
        }
        textViewMessage.setText(R.string.guess_a_number);
    }
}
