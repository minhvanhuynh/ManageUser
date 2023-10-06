/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.UserDao;

/**
 *
 * @author This PC
 */
public class UserRepository implements IUserRepository{

    @Override
    public void createUser() {
        UserDao.Instance().createUser();
    }

    @Override
    public void login() {
        UserDao.Instance().login();
    }
    
}
