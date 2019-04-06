package com.hfad.bitsandpizzas;

class Pizza {
    private final String name;
    private final int imageResourceId;

    static final Pizza[] pizzas = {
            new Pizza("Diavolo", R.drawable.diavolo),
            new Pizza("Funghi", R.drawable.funghi)
    };

    private Pizza(String name, int imageResourceId) {
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
