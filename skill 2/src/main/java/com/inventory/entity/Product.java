package com.inventory.entity;

import jakarta.persistence.*;

/**
 * Product Entity Class
 * This class represents a product in the inventory system.
 * It is mapped to the "products" table in the database using JPA annotations.
 */
@Entity
@Table(name = "products")
public class Product {
    
    /**
     * Primary key - id
     * Using AUTO generation strategy which lets Hibernate choose the best strategy
     * based on the database dialect (can be TABLE, SEQUENCE, IDENTITY, or AUTO)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private String description;
    private double price;
    private int quantity;
    
    // Default constructor required by Hibernate
    public Product() {}
    
    // Parameterized constructor
    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
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
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', description='" + description + 
               "', price=" + price + ", quantity=" + quantity + "}";
    }
}

