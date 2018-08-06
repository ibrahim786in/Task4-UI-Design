package com.example.ibrahim.task4ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button begin;
    Spinner sp1, sp2, sp3;
    LinearLayout L1, L2;
    FloatingActionButton floatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin = (Button) findViewById(R.id.begin);
        final Button cancel = (Button) findViewById(R.id.cancel);
        sp1 = (Spinner) findViewById(R.id.spinner1);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        sp3 = (Spinner) findViewById(R.id.spinner3);
        L1 = (LinearLayout) findViewById(R.id.newAlarm);
        L2 = (LinearLayout) findViewById(R.id.repleableLayout);
        floatBtn = (FloatingActionButton) findViewById(R.id.floatBtn);

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation centreMove = AnimationUtils.loadAnimation(MainActivity.this, R.anim.centre_move);
                centreMove.setDuration(300);
                centreMove.setFillAfter(false);
                floatBtn.startAnimation(centreMove);
                floatBtn.setVisibility(View.GONE);

                Animation leftt_swipe = AnimationUtils.loadAnimation(MainActivity.this, R.anim.leftt_swipe);
                leftt_swipe.setDuration(300);
                leftt_swipe.setFillAfter(true);
                L1.startAnimation(leftt_swipe);
                L1.setVisibility(View.GONE);

                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
                fadeIn.setDuration(300);

                AnimationSet animation = new AnimationSet(false); //change to false
                animation.addAnimation(fadeIn);
                L2.setVisibility(View.VISIBLE);
                L2.setAnimation(animation);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation RightSwipe = AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_swipe);
                RightSwipe.setDuration(500);
                RightSwipe.setFillAfter(true);
                L1.startAnimation(RightSwipe);
                L1.setVisibility(View.VISIBLE);

                Animation fadeOut = new AlphaAnimation(1, 0);
                fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                fadeOut.setStartOffset(300);
                fadeOut.setDuration(300);

                AnimationSet animation = new AnimationSet(false); //change to false
                animation.addAnimation(fadeOut);
                L2.setVisibility(View.GONE);
                L2.setAnimation(animation);


                Animation original_place_floatbtn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.original_place_floatbtn);
                original_place_floatbtn.setDuration(300);
                original_place_floatbtn.setFillAfter(true);
                floatBtn.startAnimation(original_place_floatbtn);
                floatBtn.show();
            }
        });
    }
}
