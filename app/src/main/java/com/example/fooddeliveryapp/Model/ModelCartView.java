package com.example.fooddeliveryapp.Model;

public class ModelCartView {
    String name;
    int image,description,money;

    public ModelCartView(String name, int money, int image, int description) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
