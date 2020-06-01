package com.duy.touchlayouteventhandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout mainLayout = findViewById(R.id.mainLayout);
        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                TouchHander(event);
                return true;
            }
        });
    }

    private void TouchHander(MotionEvent event) {
        int pointerCount = event.getPointerCount();
        String actionInfo = "";

        for (int i = 0; i < pointerCount; i++) {
            int pointerId = event.getPointerId(i);
            float x = event.getX(i);
            float y = event.getY(i);
            int actionMasked = event.getActionMasked();
            String action = "";
            switch (actionMasked) {
                case MotionEvent.ACTION_DOWN :
                    action = "ACTION_DOWN";
                    break;
                case MotionEvent.ACTION_UP :
                    action = "ACTION_UP";
                    break;
                case MotionEvent.ACTION_MOVE :
                    action = "ACTION_MOVE";
                    break;
            }

            actionInfo += "ID " + pointerId + "; x = " + x + "; y = " + y + "; " + action + "\n";
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(actionInfo);
    }
}
