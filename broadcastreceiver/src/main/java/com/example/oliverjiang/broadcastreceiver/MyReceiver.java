package com.example.oliverjiang.broadcastreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/2/26.
 */
//In particular, you may not show a dialog or bind to a service from within a BroadcastReceiver.
// For the former, you should instead use the NotificationManager API. For the latter,
// you can use Context.startService() to send a command to the service.
public class MyReceiver extends BroadcastReceiver {
    private NotificationManager manager;
    private Notification.Builder builder;
    @Override//此方法中可以进行非耗时操作
    public void onReceive(Context context, Intent intent) {
        manager =(NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.girlj);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentTitle("BroadcastReceiver:you have a new message");
        builder.setContentText("hello world");
        manager.notify(1000,builder.build());





    }
}
