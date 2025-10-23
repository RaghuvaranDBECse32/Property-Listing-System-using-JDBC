package com.property.management;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PropertyDAO dao = new PropertyDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Property Management System ===");
            System.out.println("1. Add Property");
            System.out.println("2. View All Properties");
            System.out.println("3. Update Property Price");
            System.out.println("4. Delete Property");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter location: ");
                    String location = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter type: ");
                    String type = sc.nextLine();
                    dao.addProperty(new Property(title, location, price, type));
                    break;

                case 2:
                    List<Property> list = dao.getAllProperties();
                    System.out.println("\n--- Property List ---");
                    for (Property p : list) {
                        System.out.println(p.getId() + " | " + p.getTitle() + " | " +
                                           p.getLocation() + " | ₹" + p.getPrice() + " | " + p.getType());
                    }
                    break;

                case 3:
                    System.out.print("Enter property ID: ");
                    int idUpdate = sc.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    dao.updateProperty(idUpdate, newPrice);
                    break;

                case 4:
                    System.out.print("Enter property ID to delete: ");
                    int idDelete = sc.nextInt();
                    dao.deleteProperty(idDelete);
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
