package com.example.demoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.demoandroid.FindBeer.BeerExpert;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        String beerColor = String.valueOf(color.getSelectedItem());

        BeerExpert expert = new BeerExpert();
        List<String> brandsList = expert.getBrands(beerColor);

        StringBuilder brandFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandFormatted.append(brand).append("\n");
        }
        brands.setText(brandFormatted);
    }
}
