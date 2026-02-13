/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Januario Henrique
 */

// creating class to save private informations

class Person {
    private static int counter = 1; // auto ID
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.id = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
}

// Main class
public class App {

    public static void main(String[] args) {

        ArrayList<Person> people = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean condition = true;

        while (condition) {

            System.out.println("\n===========================");
            System.out.println(" HOTEL MANAGEMENT SYSTEM");
            System.out.println("===========================");
            System.out.println("1. Register Client");
            System.out.println("2. Update Client");
            System.out.println("3. Delete Client");
            System.out.println("4. Display All Clients");
            System.out.println("5. Find Client by ID");
            System.out.println("0. Exit");
            System.out.println("----------------------------");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // REGISTER
                case 1:
                    System.out.print("Enter number of clients: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < n; i++) {

                        String first;
                        while (true) {
                            System.out.print("Enter first name: ");
                            first = sc.nextLine();

                            if (first.matches("^[\\p{L} ]+$")) {
                                break;
                            } else {
                                System.out.println("Invalid name! Only letters allowed.");
                            }
                        }

                        String last;
                        while (true) {
                            System.out.print("Enter last name: ");
                            last = sc.nextLine();

                            if (last.matches("^[\\p{L} ]+$")) {
                                break;
                            } else {
                                System.out.println("Invalid name! Only letters allowed.");
                            }
                        }

                        int age;
                        while (true) {
                            System.out.print("Enter age: ");
                            if (sc.hasNextInt()) {
                                age = sc.nextInt();
                                sc.nextLine();

                                if (age > 0 && age <= 120) {
                                    break;
                                } else {
                                    System.out.println("Invalid age! Must be between 1 and 120.");
                                }

                            } else {
                                System.out.println("Invalid input! Enter numbers only.");
                                sc.nextLine();
                            }
                        }

                        people.add(new Person(first, last, age));
                    }

                    System.out.println("Client(s) registered successfully!");
                    break;

                // UPDATE
                case 2:
                    System.out.print("Enter client ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Person p : people) {
                        if (p.getId() == updateId) {

                            System.out.print("New first name: ");
                            p.setFirstName(sc.nextLine());

                            System.out.print("New last name: ");
                            p.setLastName(sc.nextLine());

                            System.out.print("New age: ");
                            p.setAge(sc.nextInt());
                            sc.nextLine();

                            System.out.println("Client updated!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Client not found!");
                    }
                    break;

                // DELETE
                case 3:
                    System.out.print("Enter client ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    boolean removed = people.removeIf(p -> p.getId() == deleteId);

                    if (removed) {
                        System.out.println("Client removed!");
                    } else {
                        System.out.println("Client not found!");
                    }
                    break;

                // DISPLAY
                case 4:
                    if (people.isEmpty()) {
                        System.out.println("No clients registered.");
                    } else {
                        for (Person p : people) {
                            System.out.println(
                                    "ID: " + p.getId() + " | " +
                                    p.getFirstName() + " " +
                                    p.getLastName() + " | Age: " +
                                    p.getAge());
                        }
                    }
                    break;

                // FIND BY ID
                case 5:
                    System.out.print("Enter client ID: ");
                    int searchId = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for (Person p : people) {
                        if (p.getId() == searchId) {
                            System.out.println("Client found:");
                            System.out.println(
                                    "ID: " + p.getId() + " | " +
                                    p.getFirstName() + " " +
                                    p.getLastName() + " | Age: " +
                                    p.getAge());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Client not found!");
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using the system!");
                    condition = false;
                    break;

                default:
                    System.out.println("Wrong choice!");
            }
        }

        sc.close();
    }
}
