package com.xm.study.keepalive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xm.study.R;
import com.xm.study.keepalive.service.GrayService;

public class KeepAliveActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep_alive);
        intent = new Intent(this, GrayService.class);
        startService(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(intent);
    }
}
