package com.thomaskuenneth.i18ndemo;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Locale current = getResources().getConfiguration().getLocales().get(0);
        TextView textViewHello = findViewById(R.id.textViewHello);
        textViewHello.setText(current.getDisplayCountry());

        EditText editText = findViewById(R.id.editText);
        editText.setOnEditorActionListener((view, actionId, event) -> {
            textViewHello.setText(getString(R.string.template, editText.getText()));
            editText.setSelection(0, editText.getText().length());
            return true;
        });
    }
}
