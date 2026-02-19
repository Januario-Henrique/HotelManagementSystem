/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Janaurio Henrique
 */
public class HotelManagementApp {
    public static void main(String[] args) throws SQLException {
        // validation declaration
        boolean condition = true;
        int id;
        String name;
        String phoneNumber;
        String email;
        int age;
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_thursday_2026";
        String dbUsername = "root";
        String dbPassword = "";
        
        
        while(condition){
            System.out.println("=============================");
            System.out.println("1.Register Client ");
            System.out.println("2.Update Client");
            System.out.println("3.Delete Client");
            System.out.println("4.Display all Client");
            System.out.println("5. Find Client By id");
            System.out.println("0.Exit");
            System.out.println("--------------------------------");
            System.out.println("Chose: ");
            
           Scanner input = new Scanner(System.in);
           int choice = input.nextInt();
           
           switch(choice){
               case 1:
                   System.out.println("Register a Client: ");
                   System.out.print("Enter client Id: ");
                   id= input.nextInt();
                   System.out.print("Enter client name: ");
                   name= input.next();
                   System.out.print("Enter client Phone Number: ");
                   phoneNumber = input.next();
                   System.out.print("Enter client email: ");
                   email = input.next();
                   System.out.print("Enter client age: ");
                   age = input.nextInt();
                   // sourround with try and catch
                   try{
                       //0. ROAD and register database drive
                   //step 1: create connection
                       Connection con = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
                   // step 2: create statement
                       Statement st = con.createStatement();
                       
                   //step 3: perforrm db operation: create
                        //String sql = "INSERT INTO client(id,name,phone_number,email,age) VALUES (%d,'%s','%s','%s',%d)";
                        String sql = String.format("INSERT INTO client(id,NAME,phone_number,email,age) VALUES (%d,'%s','%s','%s',%d)", id,name,phoneNumber,email,age);
                        /*            boolean isSaved = st.execute(sql);
                        if(isSaved){
                            System.out.println("Data saved successful");
                        }else{ 
                            System.out.println("Data not saved");
                        }*/
                        
                        int rowAffected = st.executeUpdate(sql);
                        if(rowAffected > 0){
                            System.out.println("Data saved successful");
                        }else{ 
                            System.out.println("Data not saved");
                        }
                    //step 4 : close connection
                        con.close();
                    
                    }catch(Exception ex){
                        System.out.println("Error: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                   
                   
                   
                        
                   break;
                case 2:
                   System.out.println("Option 2 selected");
                   System.out.print("Enter client id to update: ");
                   id= input.nextInt();
                   System.out.print("Enter new name: ");
                   name=input.next();
                   System.out.print("Enter new phone number: ");
                   phoneNumber= input.next();
                   System.out.print("Enter new email: ");
                   email=input.next();
                   System.out.print("Enter new Age: ");
                   age= input.nextInt();
                   
                   try{
                       Connection con = DriverManager.getConnection(jdbcUrl,dbUsername, dbPassword);
                       
                       Statement st = con.createStatement();
                       
                       String sql = "UPDATE client SET NAME=?, phone_number=?, email=?, age=? WHERE id=?";
                       PreparedStatement ps = con.prepareStatement(sql);
                       
                       ps.setString(1, name);
                       ps.setString(2, phoneNumber);
                       ps.setString(3, email);
                       ps.setInt(4, age);
                       ps.setInt(5, id);
                       
                       int rowAffected = ps.executeUpdate();
                       
                       if(rowAffected > 0){
                           System.out.println("Client update successfully");
                       }else{
                           System.out.println("Client not found");
                       }
                       con.close();
                   }catch(Exception ex){
                       System.out.println("Error: "+ ex.getMessage());
                       ex.printStackTrace();
                   
                   }
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
                   System.out.println("Option 0 selecte");
                   System.exit(0);
                   break;
                default:
                    System.out.println("Wrong choice");
                   
               
           }
        
        }
    }
}
