package com.example.fooddeliveryapp.Model;

public class ModelPopular {
    String name;
    int image;
    int no;

    public ModelPopular(String name, int image, int no) {
        this.name = name;
        this.image = image;
        this.no = no;
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

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
