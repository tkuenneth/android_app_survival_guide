package com.thomaskuenneth.jobschedulerdemo;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class JobSchedulerDemoService extends JobService {

    private static final String TAG =
            JobSchedulerDemoService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
    }

    @Override
    public boolean onStartJob(final JobParameters params) {
        Log.d(TAG, "onStartJob()");
        Thread t = new Thread(() -> {
            Log.d(TAG, "Job in Aktion");
            jobFinished(params, false);
        });
        t.start();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG, "onStopJob()");
        return false;
    }
}
