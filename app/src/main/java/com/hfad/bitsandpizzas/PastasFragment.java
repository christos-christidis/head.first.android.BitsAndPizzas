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

public class PastasFragment extends Fragment implements CaptionedImagesAdapter.ClickObserver {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView pastaRecyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_pastas, container, false);

        String[] pastaNames = new String[Pasta.pastas.length];
        for (int i = 0; i < pastaNames.length; i++) {
            pastaNames[i] = Pasta.pastas[i].getName();
        }

        int[] pastaImages = new int[Pasta.pastas.length];
        for (int i = 0; i < pastaImages.length; i++) {
            pastaImages[i] = Pasta.pastas[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(pastaNames, pastaImages, this);
        pastaRecyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pastaRecyclerView.setLayoutManager(layoutManager);

        return pastaRecyclerView;
    }

    @Override
    public void onClick(int position) {
        Activity hostActivity = getActivity();
        if (hostActivity != null) {
            Intent intent = PastaDetailActivity.newIntent(hostActivity, position);
            hostActivity.startActivity(intent);
        }
    }
}
