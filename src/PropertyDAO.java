package com.raghuvaran.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {

    public void addProperty(Property p) {
        String sql = "INSERT INTO properties (name, location, price) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getLocation());
            ps.setDouble(3, p.getPrice());
            ps.executeUpdate();
            System.out.println("✅ Property added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Property> listProperties() {
        List<Property> list = new ArrayList<>();
        String sql = "SELECT id, name, location, price FROM properties";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Property(rs.getInt("id"), rs.getString("name"), rs.getString("location"), rs.getDouble("price")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateProperty(int id, String name, String location, double price) {
        String sql = "UPDATE properties SET name=?, location=?, price=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, location);
            ps.setDouble(3, price);
            ps.setInt(4, id);
            int updated = ps.executeUpdate();
            if (updated>0) System.out.println("✅ Property updated");
            else System.out.println("❌ No property with given id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProperty(int id) {
        String sql = "DELETE FROM properties WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int deleted = ps.executeUpdate();
            if (deleted>0) System.out.println("✅ Property deleted");
            else System.out.println("❌ No property with given id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
