package com.hqs.vevo.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.hqs.vevo.MainActivity;
import com.hqs.vevo.R;

/**
 * Created by Hqs on 2017/11/9
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置全屏 ， 必须在 setContentView() 之前
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToMain();
            }
        },2000);
    }

    private void goToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        //  Activity 的跳转， 设置 Material Design 的动画
        // 在 res 文件夹下，创建一个 transition 文件夹
        // 在文件夹里 创建动画文件
        // 在 style 里面 设置 <item name="android:windowExitTransition">@transition/fade</item>
        if(Build.VERSION.SDK_INT >= 21 )
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        else
            startActivity(intent);
        finish();
    }
}
