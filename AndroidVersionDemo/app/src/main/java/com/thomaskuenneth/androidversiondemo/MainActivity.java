package com.thomaskuenneth.androidversiondemo;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Thread t = new Thread(this::setImage);
            t.start();
        } else {
            setImageOld();
        }

        TextView version = findViewById(R.id.version);
        version.setText(String.format(Locale.US, "Android %s",
                Build.VERSION.RELEASE));
        TextView apiLevel = findViewById(R.id.apiLevel);
        apiLevel.setText(String.format(Locale.US, "API-Level %d",
                Build.VERSION.SDK_INT));
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
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

    private void setImageOld() {
        AssetManager am = getAssets();
        try (InputStream is = am.open("Beanie_App-Icon.png")) {
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            ImageView view = findViewById(R.id.imageView);
            view.setImageBitmap(bitmap);
        } catch (IOException e) {
            Log.e(TAG, "Could not decode file", e);
        }
    }
}
