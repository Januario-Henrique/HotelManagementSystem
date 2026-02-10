/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Januario Henrique
 */

// creating class to save private informations
class Person{
    String firstName;
    String lastName;
    int age;
    public Person(String firstName, String lastName,int age){
        this.firstName= firstName;
        this.lastName = lastName;
        this.age = age;
        
    }
    String getFirstName(){return firstName;} 
    String getLastName(){return lastName;}
    int getAge(){return age;}
   
}

//main class
public class App {
    public static void main(String[] args){
        ArrayList<Person> people = new ArrayList<>();
        boolean condition = true;
        
        
        while(condition){
            System.out.println("===========================");
            System.out.println(" HOTEL MANAGEMENT SYSTEM");
            System.out.println("===========================");
            System.out.println("1.Register Client");
            System.out.println("2.Update client");
            System.out.println("3.Delete client");
            System.out.println("4.Display all client");
            System.out.println("5.Find client by id");
            System.out.println("0.Exit");
            System.out.println("----------------------------");
        
        // importing Scanner library to interact with keyboard
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        
        switch(choice){
            case 1 :
                 
                System.out.println("\nEnter number of clints to be registered");
                int n =sc.nextInt();
                sc.nextLine();
                for(int i=0; i<n; i++){
                    System.out.println("Enter first name: ");
                    String first = sc.nextLine();
                    
                    System.out.println("Enter last name: ");
                    String second = sc.nextLine();
                
                    System.out.println("Enter age");
                    int age = sc.nextInt();
                    sc.nextLine();

                    people.add(new Person(first, second, age));
                
                }
                
                break;
            case 2:
                System.out.println("Option 2 selected");
                break;
            case 3:
               System.out.println("Option 3 selected");
                break;
            case 4:
                System.out.println("Option 4 selected");
                
                for(Person p: people){
                    System.out.println(
                            p.getFirstName()+" "+
                            p.getLastName() +"-"+
                            p.getAge() + "years");
                }
                break;
            case 5:
                System.out.println("Option 5 selected");
                break;
            case 0:
                System.out.println("Thank you for using the system!");
                condition=false;
                
                break;   
            default:
                System.out.println("wrong choice!!");                 
        }
        
        
        }
               
    }
}
