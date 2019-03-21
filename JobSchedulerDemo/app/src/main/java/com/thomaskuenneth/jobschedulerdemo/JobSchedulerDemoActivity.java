package com.thomaskuenneth.jobschedulerdemo;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class JobSchedulerDemoActivity extends Activity {

    private static final int JOB_ID = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView tv = findViewById(R.id.textview);
        JobScheduler scheduler = getSystemService(JobScheduler.class);
        if (scheduler != null) {
            // die Klasse des Jobs
            ComponentName serviceEndpoint = new ComponentName(this,
                    JobSchedulerDemoService.class);
            JobInfo jobInfo = new JobInfo.Builder(JOB_ID, serviceEndpoint)
                    // alle 20 Minuten wiederholen
                    .setPeriodic(20 * 60 * 1000, 5 * 60 * 1000)
                    // nur wenn das Ladekabel angeschlossen ist
                    .setRequiresCharging(true)
                    .setRequiresDeviceIdle(false)
                    .build();
            // die Ausführung planen
            scheduler.schedule(jobInfo);

            // ausstehende Jobs anzeigen
            List<JobInfo> jobs = scheduler.getAllPendingJobs();
            StringBuilder sb = new StringBuilder();
            for (JobInfo info : jobs) {
                sb.append(info.getService().getShortClassName() + "\n");
                sb.append("isPeriodic(): " + info.isPeriodic() + "\n");
                sb.append("isRequireCharging(): " + info.isRequireCharging() + "\n");
                sb.append("isRequireDeviceIdle(): " + info.isRequireDeviceIdle() + "\n");
            }
            if (sb.length() == 0) {
                sb.append(getString(R.string.no_jobs));
            }

            tv.setText(sb.toString());
        }
    }
}
