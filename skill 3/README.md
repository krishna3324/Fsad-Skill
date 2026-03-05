# Hibernate HQL Skill 3 - Sorting, Pagination & Aggregates

## Overview
This project demonstrates advanced HQL operations including:
- Sorting (ASC/DESC)
- Pagination
- Aggregate functions (COUNT, MIN, MAX, AVG, SUM)
- GROUP BY operations
- Filtering with WHERE
- Pattern matching with LIKE

## Technologies
- Java 8+
- Hibernate 5.x
- MySQL
- Maven

## Project Structure
```
hibernate-hql-skill3/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── entity/
│   │   │       │   └── Product.java
│   │   │       ├── util/
│   │   │       │   └── HibernateUtil.java
│   │   │       ├── loader/
│   │   │       │   └── ProductDataLoader.java
│   │   │       └── demo/
│   │   │           └── HQLDemo.java
│   │   └── resources/
│   │       └── hibernate.cfg.xml
├── pom.xml
├── .gitignore
└── README.md
```

## Setup
1. Clone the repository
2. Update database credentials in`
3. Run `hibernate.cfg.xml `ProductDataLoader` to populate sample data
4. Execute queries from `HQLDemo` class

## Tasks Completed
- Product entity setup
- Sample data insertion
- Sorting by price and quantity
- Pagination implementation
- Aggregate operations
- GROUP BY queries
- Price range filtering
- LIKE pattern matching

## Author
[Your Name]

