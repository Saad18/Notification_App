package com.example.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

import java.util.Random;

import static com.example.notificationapp.App.CHANNEL_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = NotificationManagerCompat.from(this);

        for (int j = 0; j <60000; j++){
            showNotification(j);

        }
//        showNotification();
    }
    //public void showNotification(View v) {
    public void showNotification(int i) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 65;
        RemoteViews collapsedView = new RemoteViews(getPackageName(),
                R.layout.notification_collasped);
        RemoteViews expandedView = new RemoteViews(getPackageName(),
                R.layout.notification_expanded);
        Intent clickIntent = new Intent(this, NotificationReceiver.class);
        PendingIntent clickPendingIntent = PendingIntent.getBroadcast(this,
                0, clickIntent, 0);
        collapsedView.setTextViewText(R.id.text_view_collapsed_1, "Hello World!");
//        for (int i =0; i<500; i++){
//            Thread thread = new Thread(() -> {
//                try {
//                        Thread.sleep(1000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            thread.start();
//            collapsedView.setTextViewText(R.id.text_view_collapsed_2, "Hello World...!"+ i);
//        }
        collapsedView.setTextViewText(R.id.text_view_collapsed_2, "Hello World...!"+ i);
        collapsedView.setTextViewText(R.id.text_view_collapsed_3, "Hello World something went worng...!"+i+"Y:"+ i);
        collapsedView.setTextViewText(R.id.text_view_collapsed_4, "Hello World something went worng bla bla bla bla ...!"+i);
//        expandedView.setImageViewResource(R.id.image_view_expanded, R.drawable.ic_android);
//        expandedView.setOnClickPendingIntent(R.id.image_view_expanded, clickPendingIntent);
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_android)
                .setCustomContentView(collapsedView)
//                .setCustomBigContentView(expandedView)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .build();
        notificationManager.notify(1, notification);
    }
}