PropertyListingSystem_JDBC

Instructions:
1. Import this folder as a Maven project into Eclipse (File -> Import -> Existing Maven Projects).
2. Create database and table in MySQL:
   CREATE DATABASE propertydb;
   USE propertydb;
   CREATE TABLE properties (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(100),
     location VARCHAR(100),
     price DOUBLE
   );
3. Run MainApp (run as Java application). MySQL credentials are set to root / 13082002.
