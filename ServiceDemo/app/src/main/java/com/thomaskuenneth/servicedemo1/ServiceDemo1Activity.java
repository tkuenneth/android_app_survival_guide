package com.thomaskuenneth.servicedemo1;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Since Android Pie (API level 28) permission android.permission.FOREGROUND_SERVICE
 * is needed.
 */
public class ServiceDemo1Activity extends Activity {

    private static final int RQ_CALL_LOG = 123;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (checkSelfPermission(Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]
                            {Manifest.permission.READ_CALL_LOG},
                    RQ_CALL_LOG);
        } else {
            startServiceAndFinish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[],
                                           int[] grantResults) {
        if (requestCode == RQ_CALL_LOG) {
            if ((grantResults.length > 0)
                    && (grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED)) {
                startServiceAndFinish();
            } else {
                Toast.makeText(this, R.string.denied,
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void startServiceAndFinish() {
        Intent intent = new Intent(this, DemoService.class);
        startForegroundService(intent);
        finish();
    }
}
