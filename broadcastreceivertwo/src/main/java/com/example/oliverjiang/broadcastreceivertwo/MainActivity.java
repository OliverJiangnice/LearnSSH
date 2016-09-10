package com.example.oliverjiang.broadcastreceivertwo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ConnectivityManager manager;// 判断网络的状况
    private NotificationManager notificationManager;// 需要通知去提醒用户
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            // 提醒用户网络状况有异常
            // 分别获得2G和3G、wifi的网络状况
            //提醒用户的两种方式：吐司、通知
            NetworkInfo mobileInfo = manager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            NetworkInfo wifiInfo = manager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (!mobileInfo.isConnected() || !wifiInfo.isConnected()) {
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentText("提示信息");
                builder.setContentText("网络状况有异常");
                builder.setSmallIcon(R.drawable.girlm);
                notificationManager.notify(1001,builder.build());
                //Toast.makeText(MainActivity.this,"网络异常",Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    // 注册广播
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        IntentFilter filter = new IntentFilter();//广播过滤器
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, filter);//注册广播
    }

    // 卸载广播
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        if (receiver != null) {
            unregisterReceiver(receiver);//卸载
        }
    }



}
