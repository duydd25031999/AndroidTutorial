package com.duy.addbtnbyjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // phải khai báo btn thuộc context (activity) nào
        Button button = new Button(this);
        button.setId(View.generateViewId());
        button.setText("Click here");

        ConstraintLayout mainLayout = findViewById(R.id.mainLayout);
        mainLayout.addView(button);

        ConstraintSet set = new ConstraintSet();

        set.connect(button.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        set.connect(button.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP);
        set.connect(button.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        set.connect(button.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM);

        set.constrainWidth(button.getId(), ConstraintSet.WRAP_CONTENT);
        set.constrainHeight(button.getId(), ConstraintSet.WRAP_CONTENT);
        set.setVerticalBias(button.getId(), 0.3f);
        set.setHorizontalBias(button.getId(), 0.3f);
        set.setMargin(button.getId(), ConstraintSet.TOP, 400);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * Không dùng "this" trong hàm này được
                * "this" = button
                * */
                Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_LONG).show();
            }
        });

        /*
        * Long click = event tồn tại trong lúc giữ button
        * */
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Long Clicked", Toast.LENGTH_LONG).show();
                return false;
                /*
                    false là Event chưa thực hiện xong
                    sau khi hết LongClick
                    tiếp tục thực hiện thực hiện tiếp các event trong
                */
            }
        });

        set.applyTo(mainLayout);
    }

    public void onClickBtn(View view) {
        // view chính là cái btn call event handler
        Button button = (Button) view;
        button.setText("Text changed");
    }
}
