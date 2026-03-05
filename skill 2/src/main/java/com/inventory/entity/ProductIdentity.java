package com.inventory.entity;

import jakarta.persistence.*;

/**
 * ProductIdentity Entity Class
 * This class demonstrates IDENTITY generation strategy.
 * With IDENTITY, the database auto-generates the ID using auto-increment column.
 * The ID is generated when the record is inserted.
 */
@Entity
@Table(name = "products_identity")
public class ProductIdentity {
    
    /**
     * Primary key using IDENTITY strategy
     * IDENTITY lets the database generate the ID using auto-increment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String description;
    private double price;
    private int quantity;
    
    // Default constructor required by Hibernate
    public ProductIdentity() {}
    
    // Parameterized constructor
    public ProductIdentity(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    @Override
    public String toString() {
        return "ProductIdentity{id=" + id + ", name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
    }
}

