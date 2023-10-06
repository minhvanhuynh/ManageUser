/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import model.User;
import view.Validation;

/**
 *
 * @author This PC
 */
public class UserDao {
    private static UserDao instance= null;
    private Validation validation;
    
    public UserDao(){
        this.validation= new Validation();
    }
    
    public static UserDao Instance(){
        if(instance==null){
            synchronized(UserDao.class){
                if(instance==null){
                    instance= new UserDao();
                }
            }
        }
        return instance;
    }
    
    public void createUser(){
        System.out.print("Please enter file want read: ");
        String nameFile= validation.checkInputString();
        if(!validation.checkFileExist(nameFile)){
            return;
        }
        String username= validation.checkUserName();
        String password= validation.checkPassword();
        User user= new User(username, password);
        if(validation.checkUserInFile(username, nameFile)){
            System.out.println("Username exist.");
            return;
        }
        addNewAccount(user, nameFile);
        
    }
    
    public void addNewAccount(User user, String filename){
        File file= new File(filename);
        try{
            FileWriter fw= new FileWriter(file, true);
            fw.write(user +"\n");
            fw.close();
            System.out.println("Create successful.");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void login(){
        System.out.print("Please enter file data: ");
        String nameFile= validation.checkInputString();
        if(!validation.checkFileExist(nameFile)){
            return;
        }
        String username= validation.checkUserName();
        String password= validation.checkPassword();
        if(validation.checkUserInFile(username, nameFile)){
            if(password.equals(passwordByUser(username, nameFile))){
                System.err.println("Login Successful");
            }else{
                System.err.println("Password incorrect");
            }
            
        }else{
            System.err.println("Username not exist!");
        }
        
    }
    
    public String passwordByUser(String username, String filename){
        File file= new File(filename);
        try{
            FileReader fr= new FileReader(file);
            BufferedReader buff= new BufferedReader(fr);
            String line;
            while((line= buff.readLine())!=null){
                String[] account= line.split(",");
                if(username.equals(account[0].split("=")[1])){
                    return account[1].split("=")[1];
                }
            }
            buff.close();
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
