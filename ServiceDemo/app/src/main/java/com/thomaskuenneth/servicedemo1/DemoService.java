package com.thomaskuenneth.servicedemo1;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import android.os.IBinder;
import android.provider.CallLog;
import android.provider.CallLog.Calls;
import android.util.Log;

import java.util.Date;

public class DemoService extends Service {

    private static final String TAG = DemoService.class.getSimpleName();

    private ContentObserver contentObserver;

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        contentObserver = new ContentObserver(new Handler()) {

            @Override
            public void onChange(boolean selfChange) {
                int missedCalls = getMissedCalls();
                Log.d(TAG, missedCalls + " verpasste Anrufe");
            }
        };
        getContentResolver().registerContentObserver(
                CallLog.Calls.CONTENT_URI,
                false, contentObserver);
        new Thread(() -> {
            while (contentObserver != null) {
                Log.d(TAG, new Date().toString());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Log.e(TAG, "interrupted", e);
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final String channelId = "channelId_1234";
        final NotificationChannel channel = new NotificationChannel(channelId,
                getString(R.string.app_name),
                NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager nm = getSystemService(NotificationManager.class);
        if (nm != null) {
            nm.createNotificationChannel(channel);
            Notification.Builder b = new Notification.Builder(this,
                    channelId);
            b.setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle(getString(R.string.app_name))
                    .setContentText(getString(R.string.app_name));
            startForeground(0x1234, b.build());
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        getContentResolver().unregisterContentObserver(contentObserver);
        contentObserver = null;
    }

    private int getMissedCalls() {
        int missedCalls = 0;
        String[] projection = {Calls._ID};
        String selection = Calls.TYPE + " = ?";
        String[] selectionArgs = {Integer.toString(Calls.MISSED_TYPE)};
        try {
            Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI,
                    projection, selection, selectionArgs, null);
            if (c != null) {
                missedCalls = c.getCount();
                c.close();
            }
        } catch (SecurityException e) {
            Log.e(TAG, "getMissedCalls()", e);
        }
        return missedCalls;
    }
}
