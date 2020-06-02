package com.duy.delayedtransition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;

public class SceneTransitionActivity extends AppCompatActivity {
    Scene scene1;
    Scene scene2;
    Transition transition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_transition);
        initScene();
    }

    private void initScene() {
        ConstraintLayout main2Layout = findViewById(R.id.main2Layout);
        scene1 = Scene.getSceneForLayout(main2Layout, R.layout.scene_1, this);
        scene2 = Scene.getSceneForLayout(main2Layout, R.layout.scene_2, this);
        scene1.enter();

        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);
    }

    public void gotoScene1(View view) {
        TransitionManager.go(scene1, transition);
    }

    public void gotoScene2(View view) {
        TransitionManager.go(scene2, transition);
    }
}