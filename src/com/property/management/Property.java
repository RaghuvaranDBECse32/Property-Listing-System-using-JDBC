package com.property.management;

public class Property {
    private int id;
    private String title;
    private String location;
    private double price;
    private String type;

    // Constructor
    public Property(String title, String location, double price, String type) {
        this.title = title;
        this.location = location;
        this.price = price;
        this.type = type;
    }

    public Property() {}

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
