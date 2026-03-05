package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

/**
 * ProductDAO class
 * This class provides CRUD operations for the Product entity.
 * It handles database operations using Hibernate sessions.
 */
public class ProductDAO {
    
    /**
     * Save a new product to the database
     * @param product - Product object to be saved
     */
    public void saveProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
        System.out.println("Product saved successfully: " + product.getName());
    }
    
    /**
     * Retrieve a product by its ID
     * @param id - Product ID
     * @return Product object if found, null otherwise
     */
    public Product getProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }
    
    /**
     * Update price and quantity of a product
     * @param id - Product ID to update
     * @param price - New price
     * @param quantity - New quantity
     */
    public void updateProduct(int id, double price, int quantity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            product.setPrice(price);
            product.setQuantity(quantity);
            session.update(product);
            tx.commit();
            System.out.println("Product updated successfully: " + product.getName());
        } else {
            System.out.println("Product not found with id: " + id);
        }
        session.close();
    }
    
    /**
     * Delete a product by its ID
     * @param id - Product ID to delete
     */
    public void deleteProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
            tx.commit();
            System.out.println("Product deleted successfully: " + product.getName());
        } else {
            System.out.println("Product not found with id: " + id);
        }
        session.close();
    }
    
    /**
     * Retrieve all products
     * @return List of all products
     */
    @SuppressWarnings("unchecked")
    public java.util.List<Product> getAllProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        java.util.List<Product> products = session.createQuery("FROM Product").list();
        session.close();
        return products;
    }
}

