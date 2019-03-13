package com.thomaskuenneth.androidversiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager am = getAssets();
        Thread t = new Thread(() -> {
            ImageDecoder.Source source = ImageDecoder.createSource(am, "Beanie_App-Icon.png");
            try {
                Drawable drawable = ImageDecoder.decodeDrawable(source);
                ImageView view = findViewById(R.id.imageView);
                view.setImageDrawable(drawable);
            } catch (IOException e) {
                Log.e(TAG, "Could not decode file", e);
            }
        });
        t.start();
    }
}
