package com.duy.adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DrinkCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);
        addDrinksItemsToListView();
        initClickListViewsEvent();
    }

    private void addDrinksItemsToListView() {
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this,
                R.layout.activity_drink_category,
                R.id.text1,
                Drink.drinks
        );

        ListView listView = findViewById(R.id.list_drinks);
        listView.setAdapter(listAdapter);
    }

    private void initClickListViewsEvent() {
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DrinkCategory.this, DrinkDetail.class);
                intent.putExtra(DrinkDetail.EXTRA_DRINKID, (int) id);
                startActivity(intent);
            }
        };

        ListView listView = findViewById(R.id.list_drinks);
        listView.setOnItemClickListener(itemClickListener);
    }
}
