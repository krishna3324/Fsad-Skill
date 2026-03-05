package com.inventory.entity;

import jakarta.persistence.*;

/**
 * ProductSequence Entity Class
 * This class demonstrates SEQUENCE generation strategy.
 * With SEQUENCE, the database uses a sequence object to generate unique IDs.
 * The ID is typically generated before the insert operation.
 */
@Entity
@Table(name = "products_sequence")
public class ProductSequence {
    
    /**
     * Primary key using SEQUENCE strategy
     * SEQUENCE uses a database sequence to generate IDs
     * We can specify sequence name and allocation size
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_sequence", allocationSize = 1)
    private int id;
    
    private String name;
    private String description;
    private double price;
    private int quantity;
    
    // Default constructor required by Hibernate
    public ProductSequence() {}
    
    // Parameterized constructor
    public ProductSequence(String name, String description, double price, int quantity) {
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
        return "ProductSequence{id=" + id + ", name='" + name + "', price=" + price + ", quantity=" + quantity + "}";
    }
}

