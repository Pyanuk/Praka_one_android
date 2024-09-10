package com.example.praka1;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private ImageView animatoinIV;

    private Button startBnt;

    private Button pauseBnt;

    private AnimationDrawable frameAnimatoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        animatoinIV = findViewById(R.id.animImageView);
        startBnt = findViewById(R.id.startButton);
        pauseBnt = findViewById(R.id.pauseButton);
        frameAnimatoin = (AnimationDrawable) animatoinIV.getDrawable();

        overridePendingTransition(R.anim.window_one, R.anim.window_two);

        startBnt.setOnClickListener(v -> {
            if (!frameAnimatoin.isRunning()) {
                frameAnimatoin.start();
            }
        });

        pauseBnt.setOnClickListener(v -> {
            if (frameAnimatoin.isRunning()) {
                frameAnimatoin.stop();
            }
        });

    }
}