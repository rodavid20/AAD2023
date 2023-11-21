package com.rodavid20.animationdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvMessage = findViewById(R.id.tvMessage);

        //ViewPropertyAnimator
        /*ViewPropertyAnimator animator = tvMessage.animate();
        animator.rotationY(3600f);
        animator.setDuration(10000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();
*/
        //ObjectAnimator 1
        /*ObjectAnimator animator = ObjectAnimator.ofFloat(tvMessage, View.ROTATION_X, 0f, 3600f);
        animator.setDuration(10000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();*/

        //ObjectAnimator 2
        /*ObjectAnimator animator =
                ObjectAnimator.ofArgb(tvMessage, "textColor",
                        Color.parseColor("#FFFF0000"),
                        Color.parseColor("#FF0000FF"));
        animator.setDuration(5000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();*/

        //ObjectAnimator 3
        /*ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.custom_animator);
        animator.setTarget(tvMessage);
        animator.start();*/

        //ValueAnimator
        Spannable wordtoSpan = new SpannableString(tvMessage.getText().toString());
        int textLength = tvMessage.getText().length();
        ValueAnimator animator = ValueAnimator.ofInt(1, textLength);
        animator.setRepeatCount(10);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int) animator.getAnimatedValue();
                wordtoSpan.setSpan(new ForegroundColorSpan(Color.GREEN), 0, value, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                wordtoSpan.setSpan(new ForegroundColorSpan(Color.RED), value, textLength, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                tvMessage.setText(wordtoSpan, TextView.BufferType.SPANNABLE);
                tvMessage.invalidate();
            }
        });
        animator.start();


    }
}