package com.example.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MyBroadcastReciver extends BroadcastReceiver {
    MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
       mediaPlayer = MediaPlayer.create(context,R.raw.alarm);
       mediaPlayer.start();
        Toast.makeText(context, "Alarm Start", Toast.LENGTH_SHORT).show();
    }
}
