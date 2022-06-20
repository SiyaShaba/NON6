/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task1;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.*;



public class TaskClass {
    //* declerations of variables
    public int option1;
    public String taskName;
    public String firstTwoChar="";
    public String lastTwoChar ="";
    public int taskNumber = 0 ;
    public String taskDescription;
    public int countDescript =0;
    public String developerDetail;
    public String name;
    public String surName;
    public int taskDuration;
    public String taskID;
    public String taskStatus;
    public JFrame f;
    public String tStatus;

//    Array
    public String[] Developer;
    public String[] taskDur;
    public String[] taskN;
    public String[] taskId;
    public String[] taskStats;
//    ArrayLists
    public ArrayList<String> Devs = new ArrayList<>();
    public ArrayList<String> tDur = new ArrayList<>();
    public ArrayList<String> tNames = new ArrayList<>();
    public ArrayList<String> tIds = new ArrayList<>();
    public ArrayList<String> tStats = new ArrayList<>();

    public void StartTaskClass(){
        f=new JFrame();
        // displaying welcome using JOptionpane
        JOptionPane.showMessageDialog(f,"Welcome to EasyKanBan.");

        // options for user to choose from
        String operation = "";
        operation = JOptionPane.showInputDialog("""
                                                        Select an option 
                                                        1. Add Tasks 
                                                        2. Coming Soon 
                                                        3. Quit""");

        option1 = Integer.parseInt(operation);
        switch(option1){
            case 1 -> JOptionPane.showMessageDialog(null, "Select Add Tasks");
            case 2 -> JOptionPane.showMessageDialog(null, "Select Coming Soon");
            case 3 -> JOptionPane.showMessageDialog(null, "Select Quit");
            default -> JOptionPane.showMessageDialog(null, "Thank you for your " +
                    "selection ");
        }

        // incrementing as number of starts are enter1
        if(option1 == 1){
            taskNumber ++;

            checkTaskDescription();
            returnTotalHours();
            TaskStatus();
            createTaskID();
            printTaskDetails();
            DevLongHours();
            DispDone();
            SearchTasks();
            SearchDevTasks();
            DelTask();
            DispReport();
        }

        if (option1 == 3) {
            System.exit(0);
        }
    }

    //This method ensures that the task description is not more than 50 characters.
    public boolean checkTaskDescription(){
        Scanner input= new Scanner(System.in);
        //output message for user to input Developer name and surname
        System.out.println("    Developer'S Details: ");
        System.out.println("---------------------------------");
        //name
        System.out.println("     Enter Your Name: ");
        name=input.next();
        //surname1
        System.out.println("      Enter Your Surname: ");
        surName=input.next();

        //Adding name and surname to the Developer Array
        String fullName = name + " " + surName;
        Devs.add(fullName);
        Developer = new String[Devs.size()];
        Devs.toArray(Developer);

        System.out.println("---------------------------------");
        System.out.println("Developer's Details successfully captured: ");


        System.out.println("**************************************");
        System.out.println("Please Enter Task Name: ");
        taskName=input.next();

        tNames.add(taskName);
        taskN = new String[tNames.size()];
        tNames.toArray(taskN);

        // A short description of the task will be entered here
        Scanner descrip = new Scanner(System.in);
        System.out.println("Please Enter Task Description: \n");
        taskDescription = descrip.next();


        // setting condition for the task description
        for (int i = 0; i < taskDescription.length(); i++){
            if(taskDescription.charAt(1) != ' '){
                countDescript ++;
            }
        }
        if(countDescript < 50 ){
            System.out.println("Task successfully captured:  ");
        }
        else
            System.out.println("Please enter a task description of less than 50 characters ");
        return false;
    }

    // The system autogenerate a TaskID
    public String createTaskID(){
        firstTwoChar = taskName.substring(0,2);
        lastTwoChar = surName.substring(surName.length() - 2);

        taskID = (firstTwoChar+":"+taskNumber+":"+lastTwoChar);

        tIds.add(taskID);
        taskId = new String[tIds.size()];
        tIds.toArray(taskId);
        return null;
    }

    // This method returns the total combined hours of all entered tasks.
    public int returnTotalHours(){

        Scanner time = new Scanner(System.in);

        System.out.println("Please Enter Task Duration:  ");
        taskDuration = Integer.parseInt(time.next());
        tDur.add(String.valueOf(taskDuration));
        taskDur = new String[tDur.size()];

        tDur.toArray(taskDur);

        return 0;
    }

    // User is given a menu to select task status
    public void TaskStatus(){
        Scanner select = new Scanner(System.in);

        System.out.println("        Please Select:   ");
        System.out.println("___________________________________");
        System.out.println("| 1.    To Do             |");
        System.out.println("| 2.    Done              |");
        System.out.println("| 3.    Doing             |");
        System.out.println("_____________________________________");
        taskStatus = select.next();
        switch (taskStatus) {
            case "1":
                tStatus = "TO DO";
                tStats.add(tStatus);
                taskStats = new String[tStats.size()];
                tStats.toArray(taskStats);
                break;
            case "2":
                tStatus = "DONE";
                tStats.add(tStatus);
                taskStats = new String[tStats.size()];
                tStats.toArray(taskStats);
                break;
            case "3":
                tStatus = "DOING";
                tStats.add(tStatus);
                taskStats = new String[tStats.size()];
                tStats.toArray(taskStats);
                break;
            //should user insert an invalid option
            default:
                System.out.println("\n404 Error!!!!!!!!!!!!!!!!!!! INVALID SELECTION");

                break;
        }

    }

    // This method returns the task full task details of each task.
    public String printTaskDetails(){

        JOptionPane.showMessageDialog(null,"Task Name   "
                +taskName + "\n Task Number:  "
                + taskNumber+ "\n Task Description:  "
                + taskDescription+ "\n Developer Details: "
                + name+" "+surName + "\n Task Duration:   "
                + taskDuration+"hrs" + "\n TaskID:    "
                + taskID.toUpperCase() + "\n Task Status: " + tStatus);

        return null;
    }

    //Developer with the longest Task Duration
    public String DevLongHours() {
        String ans = JOptionPane.showInputDialog(f, "Yes or No?");

        try {
            switch (ans) {
                case "Yes": {
                    try {
                        Scanner inp = new Scanner(System.in);
                        String input = String.valueOf(inp);
                        for (int i = 0; i <= Developer.length - 2; i++) {
                            if (Developer[i] == input) {
                                String devDur = Developer[i] + ", " + taskDur[i];
                                JOptionPane.showMessageDialog(f, devDur);
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(f, e);
//                        System.exit(0);
                    }
                    break;
                }
                case "No": {
                    System.exit(0);
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e);
        }
    return null;
//
    }

    //All Developers, task Names and duration with the status of done
    public String DispDone() {
        try {
            for (int i = 0; i <= taskStats.length -2; i++) {
                if (taskStats[i] == "DONE") {
                    String allDevs = Developer[i] + taskN[i] + taskDur[i];
                    JOptionPane.showMessageDialog(f, allDevs + " " + tDur.size());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e);
            System.exit(0);
        }
        return null;
    }

    public String SearchTasks() {
        try {
            System.out.println("Search For Tasks:");
            Scanner tasks = new Scanner(System.in);

            for (int i = 0; i <= taskN.length - 2; i++) {
                try {
                    if (String.valueOf(tasks) == taskN[i]) {
                        String result = Developer[i] + ", " + taskN[i];
                        System.out.println(result);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(f, "SearchTasks");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e);
            System.exit(0);
        }
        return null;
    }

    public String SearchDevTasks() {
        try {
            System.out.println("Search For Developer Tasks:");
            Scanner dev = new Scanner(System.in);
            for (int i = 0; i <= Developer.length - 2; i++) {
                if (String.valueOf(dev) == Developer[i]) {
                    String result = taskN[i];
                    System.out.println(result);
                } else {
                    JOptionPane.showMessageDialog(f, "SearchDevTask");
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(f, e);
            System.exit(0);
        }
        return null;
    }

    public void DelTask() {
        try {
            String option = JOptionPane.showInputDialog(f, "Do you want to Delete any tasks? 1 or 2?");

            switch (option) {
                case "1": {
                    try {
                        for (int i = 0; i <= taskN.length - 2; i++) {
                            String report = taskN[i];
                            taskN[i] = taskN[i + 1];
                            System.out.println("Entry of " + report + " successfully deleted");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(f, "DelTask");
                        System.exit(0);
                    }
                    break;
                }
                case "2": {
                    System.out.println("Ok");
                    break;
                }

            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(f, e);
            System.exit(0);
        }

    }

    public String DispReport() {
        int devCount = Developer.length;
        int taskCount = taskN.length;

        System.out.println(devCount + " developers created " + taskCount + " during this session.");
        System.exit(0);
        return null;
    }
}