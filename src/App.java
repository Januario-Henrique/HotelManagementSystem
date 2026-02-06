/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Januario Henrique
 */
public class App {
    public static void main(String[] args){
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
                System.out.println("Option 1 selected");
                break;
            case 2:
                System.out.println("Option 2 selected");
                break;
            case 3:
               System.out.println("Option 3 selected");
                break;
            case 4:
                System.out.println("Option 4 selected");
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
