/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.task1;

/**
 *
 * @author sibus
 */
public class Login {
    private String userName;
    private String loginUserName;
    private String password;
    private String loginPassword;
    private String firstName;
    private String lastName;         
            
    public Login()
    {
        userName = " "; 
        password = " "; 
        firstName = " "; 
        lastName = " "; 
        loginUserName = " "; 
        loginPassword = " ";
    }
    
    public Login(String useName, String pass, String fName, String lName, String loginUser, String loginPass)
    {
        userName = useName;
        password = pass;
        firstName = fName;
        lastName = lName;
        loginUserName = loginUser;
        loginPassword = loginPass;
    }
    
    public void setUserName(String name){userName = name;}
    
    public void setPassword(String pass){ password = pass;}
    
    public void setFirstName(String name){firstName = name;}
    
    public void setSurname(String name){lastName = name;}
    
    public void setLoginUserName(String user){loginUserName = user;}
    
    public void setLoginPassword(String pass){ loginPassword = pass;}
    
    public String getUserName(){ return userName;}
    
    public String getPassword(){return password;}
    
    public String getFirstName(){return firstName;}
    
    public String getLastName(){return lastName;}
    
    public String getLoginUserName(){return loginUserName;}
    
    public String getLoginPassword(){return loginPassword;}
    
    //Checks if username contains an underscore.
    public Boolean checkUserName() 
    {
        int index = userName.indexOf("_");
        
        if(index == -1){
            return false;}       
        return true;}  
    
   //Checks if password meets conditions.
    public Boolean checkPasswordComplexity() 
    {
        Boolean num = false; Boolean capLetter = false;  Boolean char99is = false;  Boolean allow_char = false; 
        char cha;
        String specialChar = "`¬!£$%^&*_)(-=+#~}'{/;:?>,<.@";
        
        //Checks if the password has at least 8 charachters.
        if(password.length() >= 8)
        {
            char99is = true;
        }
        
        //Checks if password cotains a number, captial letter and a special character.
        for(int i = 0; i < password.length(); i++)
        {
            cha = password.charAt(i);
            
            if(Character.isDigit(cha)){
                num = true;}
            else if(Character.isUpperCase(cha)){
                capLetter = true;}
            else if(specialChar.contains(Character.toString(cha))){
                allow_char = true;} 
        }
        
        //Conforms that password meets the password complexity requirements.
        if((num == true) && (capLetter == true) && (char99is == true) && (allow_char == true))
        {
            return true;
        }
        
        return false;
    }
    
    //Display registration message.
    public String registerUser() 
    {
        String message = " ";
        
        //Display message if the username is not correctly formatted.
        if(checkUserName() == false){
            message = "The username is incorrectly formatted.";}
        
        //Display message if the password does not meet the requirements.
        else if(checkPasswordComplexity() == false){
           message = "The password does not meet the complexity requirements.";}
        
        //Sends message if both the username and password meets the requirements.
        else if((checkUserName() == true) && (checkPasswordComplexity() == true)){
           message = "WELL DONE!!, You have been registered succesfully..";}
        
        return message;
    }
    
    //Checks if the user login detials matches the registration details.
    public Boolean loginUser() 
    {
        if((userName == loginUserName) && (password == loginPassword)){return true;}        
        return false;}
    
    public String returnLoginStatus()
    {
        String mesg = " ";     
        if(loginUser() == true){
            mesg = "Login Unsuccessfully.";}
        else{
            mesg = "Logged Successful.";
        }

        return mesg;
    }
    
}
