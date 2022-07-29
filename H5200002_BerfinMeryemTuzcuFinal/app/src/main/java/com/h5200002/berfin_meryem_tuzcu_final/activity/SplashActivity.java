package com.h5200002.berfin_meryem_tuzcu_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5200002.berfin_meryem_tuzcu_final.R;
import com.h5200002.berfin_meryem_tuzcu_final.util.AlertUtil;
import com.h5200002.berfin_meryem_tuzcu_final.util.Constans;
import com.h5200002.berfin_meryem_tuzcu_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    Context context;
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context =  this;
        activity = this;
        setContentView(R.layout.activity_splash);

        timerStart();
    }
    private void timerStart() {


        CountDownTimer countDownTimer = new CountDownTimer(Constans.INTERVAR, Constans.MILISECOND) {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                NetworkUtil nu = new NetworkUtil(getApplicationContext());
                NetworkInfo activeNetwork = nu.getActiveNetwork();
                if (activeNetwork != null)  {
                    switchScreen();
                } else {
                    warningMessage();
                }
            }
        };
        countDownTimer.start();
    }


    private void warningMessage()
    {
        AlertUtil.receiveNoInternet(context,activity);
    }

    private void switchScreen(){
        Intent ListActivity = new Intent(getApplicationContext(), com.h5200002.berfin_meryem_tuzcu_final.activity.ListActivity.class);
        startActivity(ListActivity);
        finish();
    }


}