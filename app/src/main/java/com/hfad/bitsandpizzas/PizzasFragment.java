package com.hfad.bitsandpizzas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PizzasFragment extends Fragment implements CaptionedImagesAdapter.ClickObserver {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView pizzaRecyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_pizzas, container, false);

        String[] pizzaNames = new String[Pizza.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Pizza.pizzas[i].getName();
        }

        int[] pizzaImages = new int[Pizza.pizzas.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Pizza.pizzas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pizzaNames, pizzaImages, this);
        pizzaRecyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecyclerView.setLayoutManager(layoutManager);

        return pizzaRecyclerView;
    }

    @Override
    public void onClick(int position) {
        Activity hostActivity = getActivity();
        if (hostActivity != null) {
            Intent intent = PizzaDetailActivity.newIntent(hostActivity, position);
            hostActivity.startActivity(intent);
        }
    }
}
