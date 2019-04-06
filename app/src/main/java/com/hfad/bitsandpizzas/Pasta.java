package com.hfad.bitsandpizzas;

class Pasta {
    private final String name;
    private final int imageResourceId;

    static final Pasta[] pastas = {
            new Pasta("Spaghetti Bolognese", R.drawable.spag_bol),
            new Pasta("Lasagne", R.drawable.lasagne)
    };

    private Pasta(String name, int imageResourceId) {
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
