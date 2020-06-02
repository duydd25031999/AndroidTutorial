package com.duy.delayedtransition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.slice.Slice;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;

public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        setupAnimation();
    }

    private void setupAnimation() {
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.slide);

        slide.setSlideEdge(Gravity.LEFT);
        slide.setSlideEdge(Gravity.RIGHT);

        getWindow().setEnterTransition(slide);
        getWindow().setExitTransition(slide);
    }

    public void onClick() {

    }
}