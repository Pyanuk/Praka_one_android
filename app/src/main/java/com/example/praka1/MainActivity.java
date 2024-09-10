package com.example.praka1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaPlayer = MediaPlayer.create(this, R.raw.click_button);

        setupButton(R.id.button_one, R.anim.animation_one_button, MainActivity2.class);
        setupButton(R.id.button_two, R.anim.animation_two_button, MainActivity3.class);
    }

    private void setupButton(int buttonId, int animationId, Class<?> activityClass) {
        Button button = findViewById(buttonId);
        Animation animation = AnimationUtils.loadAnimation(this, animationId);

        button.setOnClickListener(v -> {

            if (mediaPlayer != null) {
                mediaPlayer.start();
            }

            v.startAnimation(animation);
            v.postDelayed(() -> {
                startActivity(new Intent(MainActivity.this, activityClass));
            }, animation.getDuration());
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
