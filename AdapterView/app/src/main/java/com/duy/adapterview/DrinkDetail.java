package com.duy.adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkDetail extends AppCompatActivity {
    public static final String EXTRA_DRINKID = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);
        Drink drink = getDrinkFromIntent();
        setDetailInfo(drink);
    }

    private Drink getDrinkFromIntent() {
        Intent intent = getIntent();
        int drinkId = (Integer) intent.getExtras().get(EXTRA_DRINKID);
        Drink drink = Drink.drinks[drinkId];

        return drink;
    }

    private void setDetailInfo(Drink drink) {
        //Populate the drink name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(drink.getName());

        //Populate the drink description
        TextView description = (TextView)findViewById(R.id.description);
        description.setText(drink.getDescription());

        //Populate the drink image
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }
}