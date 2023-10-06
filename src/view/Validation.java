/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;




/**
 *
 * @author This PC
 */
public class Validation {
    private final static Scanner sc= new Scanner(System.in);
    
    public int checkInputIntLimit(int min, int max){
        while(true){
            try{
                int check= Integer.parseInt(sc.nextLine().trim());
                if(check < min || check > max)
                    throw new Exception();
                else return check;             
            }catch(Exception e){
                System.out.println("Please input number in range ["+min+", "+max+"]!");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public String checkInputString() {
        while (true) {
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Not allowed empty!");
                System.out.println("Enter again: ");
            } else {
                return string;
            }
        }
    }
    
    
    
    public boolean checkInputYesNo(){
        while(true){
            String result= checkInputString();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }else if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }   
    }
    
    
    
    public boolean checkFileExist(String nameFile) {
        File file = new File(nameFile);
        if (!file.exists()) {
            try {
                System.err.println("File not exist!");
                file.createNewFile();
                System.out.println("File created");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    
    public String checkUserName(){
        System.out.print("Enter username: ");
        while(true){
            String username= checkInputString();
            if(username.matches("^\\S{5}\\S*$")){
                return username;
            }
            System.err.println("You must enter at 5 character, and no space!");
            System.out.print("Enter again: ");
        }
    }
    
    public String checkPassword(){
        System.out.print("Enter password: ");
        while(true){
            String password= checkInputString();
            if(password.matches("^\\S{6}\\S*$")){
                return password;
            }
            System.err.println("You must enter at 6 character, and no space!");
            System.out.print("Enter again: ");           
        }
    }
    
    public boolean checkUserInFile(String username, String nameFile){
        File file= new File(nameFile);
        try{
            FileReader fileReader= new FileReader(file);
            BufferedReader buff= new BufferedReader(fileReader);
            String line;
            while((line = buff.readLine())!=null){
                String[] account= line.split(",");
                if(username.equals(account[0].split("=")[1])){
                    return true;
                }
            }
            buff.close();
            fileReader.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
      
    
    
}