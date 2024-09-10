package com.example.praka1;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private ImageView img;
    private Button startBtn;
    private Button pauseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        img=findViewById(R.id.img_blink);
        startBtn=findViewById(R.id.startButton);
        pauseBtn=findViewById(R.id.pauseButton);

        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink_animation);

        overridePendingTransition(R.anim.window_one, R.anim.window_two);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.startAnimation(blinkAnimation);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.clearAnimation();
            }
        });
    }

}