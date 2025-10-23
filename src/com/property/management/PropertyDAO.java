package com.property.management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {

    public void addProperty(Property property) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO properties (title, location, price, type) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, property.getTitle());
            stmt.setString(2, property.getLocation());
            stmt.setDouble(3, property.getPrice());
            stmt.setString(4, property.getType());
            stmt.executeUpdate();
            System.out.println("🏠 Property added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Property> getAllProperties() {
        List<Property> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM properties");

            while (rs.next()) {
                Property p = new Property();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setLocation(rs.getString("location"));
                p.setPrice(rs.getDouble("price"));
                p.setType(rs.getString("type"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateProperty(int id, double newPrice) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE properties SET price=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("✏️ Property updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProperty(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM properties WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("🗑️ Property deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}