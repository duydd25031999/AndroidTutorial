package com.duy.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClickListViewsEvent();
    }

    private void initClickListViewsEvent() {
        //create event listener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent, //List views was clicked
                    View view, //Which item in list was clicked
                    int position,
                    long id
            ) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, DrinkCategory.class);
                    startActivity(intent);
                }
            }
        };

        //add event listener to View
        ListView listView = findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}
