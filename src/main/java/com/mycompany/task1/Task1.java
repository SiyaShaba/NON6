/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.task1;

import java.util.Scanner;

/**
 *
 * @author sibus
 */
public class Task1 {


    public static void main(String[] args) {
        //Declearations
        String regUsername, regPassword, firstname, lastname;String loginUsername, loginPassword; TaskClass TClass; Login log; Scanner input;
        
        log = new Login();
        input = new Scanner(System.in);
        TClass = new TaskClass();
        
        //Prompts user for registration input.
        System.out.println("Hi and Welcome, please enter details to register.");
        
        
        System.out.println("Enter First Name:"); firstname = input.next();  log.setFirstName(firstname);
        
        //next line
        System.out.println("Enter Last Name:"); lastname = input.next();  log.setSurname(lastname);       
        
        //next line        
        System.out.println("Enter Username:"); regUsername = input.next(); log.setUserName(regUsername);
        
       //next line
        System.out.println("Enter Password:"); regPassword = input.next(); log.setPassword(regPassword);        
        
        //Will output error message until user inputs the correct username format.
        while((log.checkUserName() == false) || (log.getUserName().length() >5))
        {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length, please enter proper username");
            System.out.print("Enter suitable username :");
            regUsername = input.next();
            log.setUserName(regUsername);
        }//next line
        System.out.println("Username caputred Successfully.");
        
        //next line
        System.out.println(" Enter password again please ");                 
        regPassword = input.next();
        log.setPassword(regPassword);          
        
        //Will display an error message until user inputs the correct password requirements.
        while(log.checkPasswordComplexity() == false)
        {
            //next line
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            System.out.print("Enter suitable password :");
            regPassword = input.next();
            log.setPassword(regPassword);
        }
        System.out.println("Password accepected successfully.");
        
        //Prompts user for login credentials.
        System.out.println(log.registerUser());
        System.out.println("==================================================");
        System.out.println(" ");
        System.out.println("Enter your login details to log in.");
        System.out.println(" ");       
        
        System.out.print("Enter username:");
        loginUsername = input.next();
        log.setLoginUserName(loginUsername);
        //next line                     
                 
        System.out.print("Enter password: ");
        loginPassword = input.next();
        log.setLoginPassword(loginPassword);
        //next line
       
        //next line
        System.out.println(" Welcome " + firstname +" "+ lastname +" "+ "it's good to see you again.");
        TClass.StartTaskClass();

        //Displays the user login status.
        if(log.loginUser() == false) {
            System.out.println(log.returnLoginStatus()); //It will disaplay "Login details are incorrect."
        }
        else {
            System.out.println(log.returnLoginStatus()); //It will display"Login Successful."
        }
    }

}
