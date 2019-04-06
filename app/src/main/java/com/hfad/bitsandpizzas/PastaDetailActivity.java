package com.hfad.bitsandpizzas;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PastaDetailActivity extends AppCompatActivity {

    private static final String EXTRA_PASTA_ID = "pastaId";

    @NonNull
    static Intent newIntent(Activity activity, int position) {
        Intent intent = new Intent(activity, PastaDetailActivity.class);
        intent.putExtra(EXTRA_PASTA_ID, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);

        MainActivity.setUpToolbar(this);

        int pastaId = getIntent().getIntExtra(EXTRA_PASTA_ID, -1);
        if (pastaId == -1) {
            return;
        }

        String pastaName = Pasta.pastas[pastaId].getName();
        TextView textView = findViewById(R.id.pasta_text);
        textView.setText(pastaName);

        int pastaImage = Pasta.pastas[pastaId].getImageResourceId();
        ImageView imageView = findViewById(R.id.pasta_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pastaImage));
        imageView.setContentDescription(pastaName);
    }
}
