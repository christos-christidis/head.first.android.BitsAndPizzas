package com.hfad.bitsandpizzas;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PizzaDetailActivity extends AppCompatActivity {

    private static final String EXTRA_PIZZA_ID = "pizzaId";

    @NonNull
    static Intent newIntent(Activity activity, int position) {
        Intent intent = new Intent(activity, PizzaDetailActivity.class);
        intent.putExtra(EXTRA_PIZZA_ID, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        MainActivity.setUpToolbar(this);

        int pizzaId = getIntent().getIntExtra(EXTRA_PIZZA_ID, -1);
        if (pizzaId == -1) {
            return;
        }

        String pizzaName = Pizza.pizzas[pizzaId].getName();
        TextView textView = findViewById(R.id.pizza_text);
        textView.setText(pizzaName);

        int pizzaImage = Pizza.pizzas[pizzaId].getImageResourceId();
        ImageView imageView = findViewById(R.id.pizza_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage));
        imageView.setContentDescription(pizzaName);
    }
}
