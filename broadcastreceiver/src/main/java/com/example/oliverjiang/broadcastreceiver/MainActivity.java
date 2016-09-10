package com.example.oliverjiang.broadcastreceiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用intent设置相关广播
                Intent intent = new Intent(MainActivity.this,MyReceiver.class);
               // Intent intent1 = new Intent();
               // intent1.setAction("org.crazyit.action.CRAZY_BROADCAST");
                sendBroadcast(intent);//发送
                
            }
        });
    }
}
