package com.example.ishrak.moody;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.moody.R;

public class LaunchScreen extends AppCompatActivity {
Button signUp;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_launch);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent = new Intent(LaunchScreen.this, MainActivity.class);
                LaunchScreen.this.startActivity(mainIntent);
                LaunchScreen.this.finish();
            }
        }, 3000);
    }

}
