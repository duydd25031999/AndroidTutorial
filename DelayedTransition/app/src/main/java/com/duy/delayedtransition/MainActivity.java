package com.duy.delayedtransition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int position = 0;
    public void onClick(View view) {
        ConstraintLayout mainLayout = findViewById(R.id.mainLayout);
        //gan delayed transition cho mainLayout
        TransitionManager.beginDelayedTransition(mainLayout);

        ConstraintSet set = new ConstraintSet();
        Button button = findViewById(R.id.button);
        int buttonId = button.getId();

        set.connect(buttonId, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        set.connect(buttonId, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);
        set.connect(buttonId, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        set.connect(buttonId, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);

        switch (position) {
            case 0:
                set.setVerticalBias(buttonId, 0.1f);
                set.setHorizontalBias(buttonId, 0.5f);
                break;
            case 1:
                set.setVerticalBias(buttonId, 0.5f);
                set.setHorizontalBias(buttonId, 0.1f);
                break;
            case 2:
                set.setVerticalBias(buttonId, 0.9f);
                set.setHorizontalBias(buttonId, 0.5f);
                break;
            case 3:
                set.setVerticalBias(buttonId, 0.5f);
                set.setHorizontalBias(buttonId, 0.9f);
                break;
        }

        position++;
        if(position > 3) {
            position = 0;
        }

        set.constrainWidth(buttonId, ConstraintSet.WRAP_CONTENT);
        set.constrainHeight(buttonId, ConstraintSet.WRAP_CONTENT);

        set.applyTo(mainLayout);
    }
}