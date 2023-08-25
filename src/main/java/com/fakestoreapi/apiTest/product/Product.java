package com.fakestoreapi.apiTest.product;

public class Product {

    private int id;
    private String tittle;
    private double price;
    private String category;
    private String description;
    private String image;


    public Product(int id, String tittle, double price, String category, String description, String image) {
        this.id = id;
        this.tittle = tittle;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
