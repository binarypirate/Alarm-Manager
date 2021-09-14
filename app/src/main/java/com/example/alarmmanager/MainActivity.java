package com.example.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button setAlarmBtn;
    EditText hour, minutes, seconds;

    int hr = 0;
    int mints = 0;
    int sec = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAlarmBtn = findViewById(R.id.setAlarmBtn);
        hour = findViewById(R.id.hour);
        minutes = findViewById(R.id.miniutes);
        seconds = findViewById(R.id.seconds);


        setAlarmBtn.setOnClickListener(v -> {
            String ghnty = hour.getText().toString();
            String minnn = minutes.getText().toString();
            String seccc = seconds.getText().toString();

            if (ghnty.isEmpty()) {
            hr = 0;
        } else {
            hr = Integer.parseInt(hour.getText().toString());
            hr = hr * 60 * 60 * 1000;
        }
            if (minnn.isEmpty()) {
            hr = 0;
        } else {
            hr = Integer.parseInt(hour.getText().toString());
            hr = hr * 60 * 60 * 1000;
        }
            if (seccc.isEmpty()) {
            sec = 0;
        } else {
            sec = Integer.parseInt(seconds.getText().toString());
            sec = (sec * 1000);
        }

            Intent intent = new Intent(this, MyBroadcastReciver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    this.getApplicationContext(), 234, intent,0
            );
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis() + hr +
                    mints+sec, pendingIntent);
            intent = new Intent();
            pendingIntent = PendingIntent.getActivity(this, 0 , intent,0);

            Notification notification = new Notification.Builder(this)
                    .setTicker("Alarm")
                    .setContentTitle("Alarm Updates")
                    .setContentText("Alarm set after " + hr + " hour "+ mints+" minutes "+(sec/1000)+" seconds")
                    .setSmallIcon(R.drawable.notify)
                    .setDefaults(Notification.DEFAULT_LIGHTS)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .setContentIntent(pendingIntent)
                    .build();
            notification.flags = Notification.FLAG_AUTO_CANCEL;
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(0, notification);

        });

    }

}