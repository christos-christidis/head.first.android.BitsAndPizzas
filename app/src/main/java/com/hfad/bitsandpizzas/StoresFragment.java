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

public class StoresFragment extends Fragment implements CaptionedImagesAdapter.ClickObserver {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView storeRecyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_stores, container, false);

        String[] storeNames = new String[Store.stores.length];
        for (int i = 0; i < storeNames.length; i++) {
            storeNames[i] = Store.stores[i].getName();
        }

        int[] storeImages = new int[Store.stores.length];
        for (int i = 0; i < storeImages.length; i++) {
            storeImages[i] = Store.stores[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(storeNames, storeImages, this);
        storeRecyclerView.setAdapter(adapter);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        storeRecyclerView.setLayoutManager(layoutManager);

        return storeRecyclerView;
    }

    @Override
    public void onClick(int position) {
        Activity hostActivity = getActivity();
        if (hostActivity != null) {
            Intent intent = StoreDetailActivity.newIntent(hostActivity, position);
            hostActivity.startActivity(intent);
        }
    }
}
