package com.hfad.bitsandpizzas;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreDetailActivity extends AppCompatActivity {

    private static final String EXTRA_STORE_ID = "storeId";

    @NonNull
    static Intent newIntent(Activity activity, int position) {
        Intent intent = new Intent(activity, StoreDetailActivity.class);
        intent.putExtra(EXTRA_STORE_ID, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        MainActivity.setUpToolbar(this);

        int storeId = getIntent().getIntExtra(EXTRA_STORE_ID, -1);
        if (storeId == -1) {
            return;
        }

        String storeName = Store.stores[storeId].getName();
        TextView textView = findViewById(R.id.store_text);
        textView.setText(storeName);

        int storeImage = Store.stores[storeId].getImageResourceId();
        ImageView imageView = findViewById(R.id.store_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, storeImage));
        imageView.setContentDescription(storeName);
    }
}
