package com.raghuvaran.jdbc;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        PropertyDAO dao = new PropertyDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Property Listing System (JDBC) ===");
            System.out.println("1. Add Property");
            System.out.println("2. View All Properties");
            System.out.println("3. Update Property");
            System.out.println("4. Delete Property");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Location: ");
                    String loc = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    dao.addProperty(new Property(name, loc, price));
                    break;
                case 2:
                    List<Property> list = dao.listProperties();
                    list.forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter id to update: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("New name: ");
                    String nname = sc.nextLine();
                    System.out.print("New location: ");
                    String nloc = sc.nextLine();
                    System.out.print("New price: ");
                    double nprice = sc.nextDouble();
                    dao.updateProperty(id, nname, nloc, nprice);
                    break;
                case 4:
                    System.out.print("Enter id to delete: ");
                    int did = sc.nextInt();
                    dao.deleteProperty(did);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
