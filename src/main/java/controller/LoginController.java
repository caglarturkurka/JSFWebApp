/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import services.LoginService;

/**
 *
 * @author caglarturkurka
 */
@ManagedBean
@RequestScoped
public class LoginController {

    /**
     * Creates a new instance of LoginController
     */
    
    private String username;
    private String password;
    
    private LoginService loginService= new LoginService();;
    
    public LoginController() {   
    }
    public String loginProcess(){
        boolean result = loginService.checkUser(username, password);
        if(result){
            return "success?faces-redirect=false";
        }else{
            return "error?faces-redirect=false";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
