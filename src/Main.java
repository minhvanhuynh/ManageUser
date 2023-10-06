
import controller.ManageUser;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author This PC
 */
public class Main {
    public static void main(String[] args) {
        String title= "USER MANAGEMENT SYSTEM";
        String[] s = new String[] {"Create a new account", "Login system", "Exit"};
        new ManageUser(title, s).run();
    }
}
