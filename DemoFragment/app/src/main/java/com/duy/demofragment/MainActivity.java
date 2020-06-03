package com.duy.demofragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.OnButtonClickCallBack {
    @Override
    public void onButtonClick(String text, int textSize) {
        Fragment2 fragment2 =
            (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        fragment2.updateText(text, textSize);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
