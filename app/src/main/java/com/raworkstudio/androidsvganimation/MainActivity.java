package com.raworkstudio.androidsvganimation;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by delacrmi on 26/12/2016.
 */

public class MainActivity extends AppCompatActivity{

    private ImageView animation_img_view;
    private AnimatedVectorDrawable animatedVectorDrawable;
    private AnimatedVectorDrawable animatedVectorDotDrawable;
    private boolean isDot = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatedVectorDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.pin_dot_connection);
        animatedVectorDotDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.dot_pin_connection);

        animation_img_view = (ImageView) findViewById(R.id.animation_img_view);
        animation_img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animate();
            }
        });


    }

    private void animate(){
        AnimatedVectorDrawable pre = isDot ? animatedVectorDotDrawable : animatedVectorDrawable;

        if(pre != null && pre.isRunning())
            pre.stop();

        AnimatedVectorDrawable current = isDot ? animatedVectorDotDrawable : animatedVectorDrawable;
        animation_img_view.setImageDrawable(current);
        current.start();
        isDot = !isDot;
    }
}
