package com.dakakolp.hometask5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private int photo;
    private String name;
    private String description;

    public static List<Product> createProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(R.drawable.heart_shaped_sushi, "Heart Shaped Sushi",
                "\tHeart Shaped Sushi\n\n" +
                        " - rice\n" +
                        " - nori seaweed\n" +
                        " - sushi vinegar (1 tbsp per 250g cooked rice)\n" +
                        " - soy sauce\n" +
                        " - wasabi paste\n" +
                        " - sushi ginger (optional)\n" +
                        " - avocado\n" +
                        " - raw tuna or salmon (optional)\n" +
                        " - tobiko fish roe egg (optional)\n" +
                        " - sesame seeds (optional)"));
        products.add(new Product(R.drawable.turkey_sushi_roll, "Turkey Sushi Roll",
                "\tTurkey Sushi Roll\n\n" +
                        " - 300g cooked rice\n" +
                        " - 80ml sushi vinegar\n" +
                        " - 1 sheet nori seaweed\n" +
                        " - cooked turkey (or chicken)\n" +
                        " - 2 tbsp teriyaki sauce (optional)\n" +
                        " - soy sauce (optional)\n" +
                        " - wasabi (optional)\n" +
                        " - sesame seeds (optional)"));
        products.add(new Product(R.drawable.hinamatsuri_sushi, "Hina Matsuri Flower Sushi",
                "\tHina Matsuri Flower Sushi\n\n" +
                        " - 300g white japanese sushi rice\n" +
                        " - 125g white japanese sushi rice with plum seasoning\n" +
                        " - nori seaweed\n" +
                        " - carrot\n" +
                        " - ham\n" +
                        " - steamed spinach"));
        products.add(new Product(R.drawable.sushi_canape, "Sushi Canapés",
                "\tSushi Canapés\n\n" +
                        " - 300g prepared sushi rice\n" +
                        " - nori seaweed sheets\n" +
                        "suggested toppings:\n" +
                        " - salmon sashimi\n" +
                        " - prawns\n" +
                        " - egg omelette\n" +
                        " - tuna\n" +
                        " - ikura (salmon roe) + cucumber\n" +
                        " - avocado + tuna + mayonnaise\n" +
                        " - cod roe + cream cheese\n" +
                        " - sashimi slices"));
        return products;
    }

    public Product(int photo, String name, String description) {
        this.photo = photo;
        this.name = name;
        this.description = description;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
