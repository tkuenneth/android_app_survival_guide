package com.thomaskuenneth.androidversiondemo;

import android.content.res.AssetManager;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Magnifier;
import android.widget.TextView;

import java.io.IOException;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // Take a look at branch androidversiondemo_api26

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread t = new Thread(this::setImage);
        t.start();

        TextView version = findViewById(R.id.version);
        version.setText(String.format(Locale.US, "Android %s",
                Build.VERSION.RELEASE));
        TextView apiLevel = findViewById(R.id.apiLevel);
        apiLevel.setText(String.format(Locale.US, "API-Level %d",
                Build.VERSION.SDK_INT));
    }

    private void setImage() {
        AssetManager am = getAssets();
        ImageDecoder.Source source = ImageDecoder.createSource(am, "Beanie_App-Icon.png");
        try {
            Drawable drawable = ImageDecoder.decodeDrawable(source);
            ImageView view = findViewById(R.id.imageView);
            view.setImageDrawable(drawable);
        } catch (IOException e) {
            Log.e(TAG, "Could not decode file", e);
        }
    }
}
