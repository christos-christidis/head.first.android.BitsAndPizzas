package com.hfad.bitsandpizzas;

class Store {
    private final String name;
    private final int imageResourceId;

    static final Store[] stores = {
            new Store("Cambridge", R.drawable.cambridge),
            new Store("Sebastopol", R.drawable.sebastopol)
    };

    private Store(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    String getName() {
        return name;
    }

    int getImageResourceId() {
        return imageResourceId;
    }
}
