package com.raworkstudio.androidsvganimation;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by delacrmi on 26/12/2016.
 */

public class MainActivity extends AppCompatActivity {

    private ImageView animation_img_view;
    private AnimatedVectorDrawable animatedVectorDrawable;
    private boolean isDot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animatedVectorDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.pin_dot_connection);

        animation_img_view = (ImageView) findViewById(R.id.animation_img_view);
        animation_img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animate();
            }
        });


    }

    private void animate(){
        AnimatedVectorDrawable pre = isDot ? null : animatedVectorDrawable;
        if(pre != null && pre.isRunning())
            pre.stop();

        AnimatedVectorDrawable current = isDot ? null : animatedVectorDrawable;
        animation_img_view.setImageDrawable(current);
        current.start();

    }
}
