package com.notificationmanager;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button b;
    Intent in;
    String channel_Id = "notification id";

    @Override

    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
     b=(Button)findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent in = new Intent();
                PendingIntent pin = PendingIntent.getActivity(MainActivity.this,0,in,0);
                Notification noti =  new Notification.Builder(MainActivity.this)
                        .setTicker("Ticker Title")
                        .setContentTitle("Sampel Notfication")
                        .setContentText("Sample Text")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .addAction(R.drawable.ic_launcher_background,"Action1",pin)
                        .addAction(R.drawable.ic_launcher_background,"Action2",pin)
                        .setContentIntent(pin).getNotification();
                noti.flags= Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0,noti);
                




            }
        });
    }}

