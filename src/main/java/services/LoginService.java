/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.LoginDAO;
import entities.Users;

/**
 *
 * @author caglarturkurka
 */
public class LoginService {
    
    private LoginDAO loginDAO;
    
    
    public LoginService(){
        loginDAO = new LoginDAO();
    }
    
    public boolean checkUser(String username,String password){
       return loginDAO.check(username, password);
    }
}
