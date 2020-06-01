package com.example.prm391lesson5;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomGestureDemoActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {
    GestureLibrary gestureLibrary;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gesture_demo);
        gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gesture);
        textView = findViewById(R.id.textView3);
        if (!gestureLibrary.load()) {
            textView.setText("File load fail");
        } else {
            GestureOverlayView overlayView = findViewById(R.id.overLayView);
            overlayView.addOnGesturePerformedListener(this);
        }
    }

    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList<Prediction> predictions = gestureLibrary.recognize(gesture);
        String infor = "";
        if (predictions.size() > 0) {
            if (predictions.get(0).score > 1) {
                infor = "Action:" + predictions.get(0).name + "\n";
            }
        }
        infor += "Score :" + predictions.get(0).score;
        textView.setText(infor);
    }
}
