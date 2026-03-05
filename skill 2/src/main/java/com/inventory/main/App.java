package com.inventory.main;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

/**
 * App class - Main application
 * This class demonstrates all CRUD operations using Hibernate
 */
public class App {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        
        System.out.println("=== Hibernate CRUD Operations Demo ===\n");
        
        // CREATE: Insert multiple Product records into the database
        System.out.println("--- CREATE: Inserting Products ---");
        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 10);
        Product p2 = new Product("Mouse", "Wireless Mouse", 1200, 50);
        Product p3 = new Product("Keyboard", "Mechanical Keyboard", 3500, 25);
        
        dao.saveProduct(p1);
        dao.saveProduct(p2);
        dao.saveProduct(p3);
        
        System.out.println("\n--- READ: Retrieving Products ---");
        // READ: Retrieve a product using its id
        Product retrievedProduct = dao.getProduct(1);
        if (retrievedProduct != null) {
            System.out.println("Product with ID 1: " + retrievedProduct);
        }
        
        // Display all products
        System.out.println("\nAll Products:");
        for (Product p : dao.getAllProducts()) {
            System.out.println(p);
        }
        
        // UPDATE: Update the price or quantity of any selected product
        System.out.println("\n--- UPDATE: Updating Product ---");
        dao.updateProduct(1, 72000, 8);  // Update Laptop price and quantity
        
        // Verify update
        Product updatedProduct = dao.getProduct(1);
        System.out.println("Updated Product: " + updatedProduct);
        
        // DELETE: Delete a product record by id if it is discontinued
        System.out.println("\n--- DELETE: Deleting Product ---");
        dao.deleteProduct(2);  // Delete Mouse product
        
        // Display all products after deletion
        System.out.println("\nAll Products after deletion:");
        for (Product p : dao.getAllProducts()) {
            System.out.println(p);
        }
        
        System.out.println("\n=== CRUD Operations Completed ===");
        
        // Close SessionFactory
        com.inventory.util.HibernateUtil.shutdown();
    }
}

