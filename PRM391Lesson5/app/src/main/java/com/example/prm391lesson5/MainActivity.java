package com.example.prm391lesson5;

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
            public boolean onTouch(View view, MotionEvent event) {
                touchHandle(event);
                return true;
            }
        });
    }

    private void touchHandle(MotionEvent event) {
        int pointerCount = event.getPointerCount(); // get ra so luong ngon tay dang touch tren man hinh
        String actionInfo = "";
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = event.getPointerId(i);
            float x = event.getX(i);
            float y = event.getY(i);
            String action = "";
            int actionMasked = event.getActionMasked();
            switch (actionMasked) {
                case MotionEvent.ACTION_DOWN:
                    action = "ACTION_DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    action = "ACTION_UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    action = "ACTION_MOVE";
                    break;

            }
            actionInfo += "ID :" + pointerId + "X :" + x + "Y: " + y + ";" + action + "\n";

        }
        TextView textView = findViewById(R.id.textView);
        textView.setText(actionInfo);

    }
}
