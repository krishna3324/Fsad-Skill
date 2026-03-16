package com.inventory.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;


public class ProductDAO {
    
    
    public void saveProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
        System.out.println("Product saved successfully: " + product.getName());
    }
    
    
    public Product getProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }
    
    
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
    
    
    @SuppressWarnings("unchecked")
    public java.util.List<Product> getAllProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        java.util.List<Product> products = session.createQuery("FROM Product").list();
        session.close();
        return products;
    }
}

