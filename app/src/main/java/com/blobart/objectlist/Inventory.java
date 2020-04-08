package com.blobart.objectlist;

public class Inventory {

    private String abbreviation;
    private String description;
    private int id;
    private int stock;

    public Inventory() {
    }

    public Inventory(String abbreviation, String description, int id, int stock) {
        this.abbreviation = abbreviation;
        this.description = description;
        this.id = id;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}

